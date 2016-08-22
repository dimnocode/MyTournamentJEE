package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Clan;
import mt.entities.User;
import mt.entities.Usersclan;
import mt.util.NmdQueries;
import mt.util.Util;
import mt.validation.ClanCreation;
import mt.validation.Validation;

/**
 * Servlet implementation class SrvClans
 */
@WebServlet("/clans")
public class SrvClans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvClans.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvClans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = Util.getLoggedUser(request);
		
		if(user != null){
			//refresfLists(user, request);
			Clan clan = new Clan();
			
			List<Clan> listClanLeader = new ArrayList<Clan>();
			List<Clan> listClan = new ArrayList<Clan>();
			
			for(Usersclan item : user.getUsersclans()){
				if(item.getUser().getIdUsers() == user.getIdUsers() && item.getClanLeader() ){
					clan = NmdQueries.findClanById(item.getClan().getIdClan());
					listClanLeader.add(clan);
				}
				if(item.getUser().getIdUsers() == user.getIdUsers() && item.getClanLeader() == false){
					clan = NmdQueries.findClanById(item.getClan().getIdClan());
					listClan.add(clan);
				}
				
			}
			
			request.setAttribute("listClanLeader", listClanLeader);
			request.setAttribute("listClan", listClan);
			request.setAttribute("loggedUser", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/clans.jsp").forward(request, response);		
		}
		else{
			response.sendRedirect("error");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		String btnClan = request.getParameter("btnClan");
		String btnUserClan = request.getParameter("btnUserClan");
		String btnRemoveUserClan = request.getParameter("btnRemoveUserClan");
		String btnRemoveClan = request.getParameter("btnRemoveClan");
		String btnReaddUserClan = request.getParameter("btnReaddUserClan");
		
		String successMsg = null;
		String errMsg = null;
		
		//CREATE CLAN
		if(btnClan != null){
			Clan clan = new Clan();
			User loggedUser = Util.getLoggedUser(request);
			Validation<Clan> v = new Validation<Clan>();
			Usersclan userClan = new Usersclan();
			
			if(v.validate(request, clan)){
				ClanCreation.create(request, clan);
				if(clan != null){
					try{
						
						logger.log(Level.INFO, loggedUser.getPseudo() + " created the clan : " + clan.getName());
						
						em.getTransaction().begin();
						em.persist(clan);
						
						em.merge(loggedUser);
						em.merge(clan);
						
						userClan.setAddedDateTime(new Date());
						userClan.setClanLeader(true);
						userClan.setUser(loggedUser);
						userClan.setClan(clan);
						
						loggedUser.addUsersclan(userClan);					
						clan.addUsersclan(userClan);					
						
						em.merge(loggedUser);
						em.merge(clan);
						em.persist(userClan);
						em.getTransaction().commit();
						successMsg = "Clan created successfully. You're the leader ! ";
						request.setAttribute("successMsg", successMsg);
						//refresfLists(loggedUser, request);
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
					
					doGet(request, response);
				}
			}else{
				doGet(request, response);
				logger.log(Level.INFO, "Clan not valid");
			}
			
		}
		//REMOVE CLAN
		if(btnRemoveClan != null){
			Clan clan = NmdQueries.findClanById(Integer.parseInt(request.getParameter("idClan")));
			if(clan != null){
				try{
					em.getTransaction().begin();
					clan.setActive(false);
					em.merge(clan);
					em.getTransaction().commit();
					successMsg = clan.getName()+ " is removed with successfully.";
					request.setAttribute("successMsg", successMsg);
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "Clan is not found";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "Clan is not found");
			}
		}
		//INVITE USERS IN CLAN
		if(btnUserClan != null){
			Clan clan = NmdQueries.findClanById(Integer.parseInt(request.getParameter("idClan")));
			User user = NmdQueries.findUserByUnique(request.getParameter("emailUserClan"), request.getParameter("pseudoUserClan"));
			
			//BESOIN DE VERIFIER SI LE USER EST DEJA INSCRIT DANS LE CLAN
			
			
			
				if(user != null){
					Usersclan userClan = new Usersclan();
					try{
						em.getTransaction().begin();
							
						userClan.setAddedDateTime(new Date());
						userClan.setClanLeader(false);
						userClan.setUser(user);
						userClan.setClan(clan);
							
						user.addUsersclan(userClan);
						clan.addUsersclan(userClan);
							
						em.merge(user);
						em.merge(clan);
						em.persist(userClan);
						em.getTransaction().commit();
							
						successMsg = user.getPseudo()+ " is added in " + clan.getName() + " with success ";
						request.setAttribute("successMsg", successMsg);
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
						
					doGet(request, response);
					logger.log(Level.INFO, user.getPseudo()+ " is added in " + clan.getName() + "with success");
				}else{
					errMsg = request.getParameter("pseudoUserClan")+ " is not found";
						
					request.setAttribute("errMsg", errMsg);
					doGet(request, response);
					logger.log(Level.INFO, "error");
				}
		}
		//REMOVE USER IN CLAN
		if(btnRemoveUserClan != null){
			
			Usersclan userClan = NmdQueries.findUserclanByIdUserIdClan(Integer.parseInt(request.getParameter("idClan")), Integer.parseInt(request.getParameter("idUser")));
			if(userClan.getUser() != null && userClan.getClan() != null){
				try{
					em.getTransaction().begin();
					userClan.getUser().getUsersclans().remove(userClan);
					userClan.getClan().getUsersclans().remove(userClan);
					
					userClan.setRemovedDateTime(new Date());
					em.merge(userClan);
					em.getTransaction().commit();
					successMsg = userClan.getUser().getPseudo() + " is removed to "+ userClan.getClan().getName();
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, userClan.getUser().getPseudo() + " is removed to "+ userClan.getClan().getName());
					//refresfLists(loggedUser, request);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}
				finally {
					em.close();
				}
				doGet(request, response);
			}else{
				errMsg = "Impossible to remove";
				
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "error");
			}
		}
		//RE ADD USER IN CLAN
		if(btnReaddUserClan != null){
			Usersclan userClan = NmdQueries.findUserclanByIdUserIdClan(Integer.parseInt(request.getParameter("idClan")), Integer.parseInt(request.getParameter("idUser")));
			if(userClan != null){
				try{
					em.getTransaction().begin();
					userClan.getUser().getUsersclans().add(userClan);
					userClan.getClan().getUsersclans().add(userClan);
					
					userClan.setRemovedDateTime(null);
					em.merge(userClan);
					em.getTransaction().commit();
					successMsg = userClan.getUser().getPseudo() + " is re add to "+ userClan.getClan().getName();
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, userClan.getUser().getPseudo() + " is re add to "+ userClan.getClan().getName());
					//refresfLists(loggedUser, request);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}
				finally {
					em.close();
				}
				doGet(request, response);
			}else{
				errMsg = "Impossible to re add";
				
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "error");
			}
		}
	}
	/*public void refresfLists(User user, HttpServletRequest request ){
		Clan clan = new Clan();
		List<Clan> listClanLeader = new ArrayList<Clan>();
		List<Clan> listClan = new ArrayList<Clan>();
		
		for(Usersclan item : user.getUsersclans()){
			if(item.getUser().getIdUsers() == user.getIdUsers() && item.getClanLeader() ){
				clan = NmdQueries.findClanById(item.getClan().getIdClan());
				listClanLeader.add(clan);
			}
			if(item.getUser().getIdUsers() == user.getIdUsers() && item.getClanLeader() == false){
				clan = NmdQueries.findClanById(item.getClan().getIdClan());
				listClan.add(clan);
			}
		}
		
		request.setAttribute("listClanLeader", listClanLeader);
		request.setAttribute("listClan", listClan);
	}*/
}
