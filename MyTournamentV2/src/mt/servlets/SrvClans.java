package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		
		String successMsg = null;
		String errMsg = null;
		
		//CREATE CLAN
		if(btnClan != null){
			Clan clan = new Clan();
			User loggedUser = Util.getLoggedUser(request);
			Validation<Clan> v = new Validation<Clan>();
			Usersclan userClan = new Usersclan();
			
			if(v.validate(request, clan)){
				ClanCreation.create(request, clan, userClan);
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
		//INVITE USERS IN CLAN
		if(btnUserClan != null){
			Clan clan = NmdQueries.findClanById(Integer.parseInt(request.getParameter("idClan")));
			//User loggedUser = Util.getLoggedUser(request);
			User user = new User();
				user = NmdQueries.findUserByUnique(request.getParameter("emailUserClan"), request.getParameter("pseudoUserClan"));
				if(user != null){
					Usersclan userClan = new Usersclan();
					try{
						
						
						em.getTransaction().begin();
						
						userClan.setAddedDateTime(new Date());
						userClan.setClanLeader(false);
						userClan.setUser(user);
						userClan.setClan(clan);
						
						user.addUsersclan(userClan);
						user.getClans().add(clan);
						clan.addUsersclan(userClan);
						clan.getUsers().add(user);
						
						em.merge(user);
						em.merge(clan);
						em.persist(userClan);
						em.getTransaction().commit();
						
						successMsg = user.getPseudo()+ " is added in " + clan.getName() + " with success ";
						request.setAttribute("successMsg", successMsg);
						//refresfLists(loggedUser, request);
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
			Clan clan = NmdQueries.findClanById(Integer.parseInt(request.getParameter("idClan")));
			User user = NmdQueries.findUserById(Integer.parseInt(request.getParameter("idUser")));
			//User loggedUser = Util.getLoggedUser(request);
			if(clan != null && user != null){
				Usersclan userClan = NmdQueries.findUserclanByIdUserIdClan(clan.getIdClan(), user.getIdUsers());
				em.getTransaction().begin();
				try{
					Clan c = new Clan();
					for(Clan item : user.getClans()){
						if(item.getIdClan() == clan.getIdClan());
						c = item;
					}
					user.getClans().remove(c);
					
					User u = new User();
					for(User item : clan.getUsers()){
						if(item.getIdUsers() == user.getIdUsers());
						u = item;
					}
					clan.getUsers().remove(u);
					
					em.merge(user);
					em.merge(clan);
					
					Usersclan uc = em.merge(userClan);
					em.remove(uc);
					
					em.getTransaction().commit();
					successMsg = u.getPseudo() + " is removed to "+ c.getName();
					request.setAttribute("successMsg", successMsg);
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
