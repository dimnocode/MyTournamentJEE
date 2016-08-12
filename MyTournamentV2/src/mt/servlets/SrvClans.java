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
		String successMsg = null;
		String errMsg = null;
		
		if(btnClan != null){
			Clan clan = new Clan();
			
			Validation<Clan> v = new Validation<Clan>();
			Usersclan userClan = new Usersclan();
			
			if(v.validate(request, clan)){
				ClanCreation.create(request, clan, userClan);
				if(clan != null){
					
					User loggedUser = new User();
					loggedUser = Util.getLoggedUser(request);
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
					em.close();
					successMsg = "Clan created successfully. You're the leader ! ";
					request.setAttribute("successMsg", successMsg);
					doGet(request, response);
				}
			}else{
				doGet(request, response);
				logger.log(Level.INFO, "Clan not valid");
			}
			
		}
		if(btnUserClan != null){
			Clan clan = NmdQueries.findClanById(Integer.parseInt(request.getParameter("idClan")));
			User user = new User();
				user = NmdQueries.findUserByUnique(request.getParameter("emailUserClan"), request.getParameter("pseudoUserClan"));
				if(user != null){
					Usersclan userClan = new Usersclan();
					
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
					em.close();
					//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account");
					//dispatcher.forward(request, response);
					doGet(request, response);
					logger.log(Level.INFO, user.getPseudo()+ " is added in " + clan.getName() + "with success");
				}else{
					errMsg = request.getParameter("pseudoUserClan")+ " is not found";
					
					request.setAttribute("errMsg", errMsg);
					//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account");
					//dispatcher.forward(request, response);
					doGet(request, response);
					logger.log(Level.INFO, "error");
				}
		}
		
	}

}
