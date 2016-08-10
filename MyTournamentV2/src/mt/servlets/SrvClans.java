package mt.servlets;

import java.io.IOException;
import java.util.Date;

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
		
		if(Util.getLoggedUser(request) != null){
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/clans.jsp").forward(request, response);
		}else{
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
		String successMsg = null;
		
		
		if(btnClan != null){
			Clan clan = new Clan();
			
			Validation<Clan> v = new Validation<Clan>();
			Usersclan userClan = new Usersclan();
			if(v.validate(request, clan)){
				ClanCreation.create(request, clan, userClan);
				if(clan != null){
					logger.log(Level.INFO, "Clan created :" + clan.getNom());
					em.getTransaction().begin();
					em.persist(clan);
					em.getTransaction().commit();
					
					User loggedUser = Util.getLoggedUser(request);
					User user = NmdQueries.findUserById(loggedUser.getIdUsers());
					logger.log(Level.INFO, "User : "+user.getPseudo());
					Clan c = NmdQueries.findClanById(clan.getIdClan());
					logger.log(Level.INFO, "Clan : "+clan.getNom());
					
					userClan.setAddedDateTime(new Date());
					userClan.setClanLeader(true);
					
					user.addUsersclan(userClan);
					userClan.setUser(user);
					
					c.addUsersclan(userClan);
					userClan.setClan(c);
					//userClan.setClan(c);
					//userClan.setUser(user);
					
					//c.getUsersclans().add(userClan);
					//user.getUsersclans().add(userClan);
					
					em.getTransaction().begin();
					em.merge(user);
					em.merge(c);
					em.persist(userClan);
					em.getTransaction().commit();
					successMsg = "Clan created and user is leader with success ";
					request.setAttribute("successMsg", successMsg);
				}
			}else{
				response.sendRedirect("clans");
				logger.log(Level.INFO, "Clan not valid");
			}
			em.close();
		}
		doGet(request, response);
	}

}
