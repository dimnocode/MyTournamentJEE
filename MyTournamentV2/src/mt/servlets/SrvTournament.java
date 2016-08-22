package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Clan;
import mt.entities.Registration;
import mt.entities.Tournament;
import mt.entities.User;
import mt.util.NmdQueries;
import mt.util.Util;

/**
 * Servlet implementation class SrvTournament
 */
@WebServlet("/tournament")
public class SrvTournament extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvTournament.class);  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvTournament() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getAttribute("tournament") != null){			
			this.getServletContext().getRequestDispatcher("/WEB-INF/tournament.jsp").forward(request, response);
		}else{
			if(session.getAttribute("createdTournament") != null){
				request.setAttribute("tournamentId", (int)session.getAttribute("createdTournament"));
				session.removeAttribute("createdTournament");
				doPost(request, response);
			} else{
				response.sendRedirect("tournamentslist");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		//---------------------------------
		//       Parameters
		//---------------------------------
		
		System.out.println("Tournoi passé au post =" + request.getParameter("tournamentId"));
		
		int tournamentId = 0;
		
		if(request.getParameter("tournamentId") != null){
			tournamentId = Integer.parseInt(request.getParameter("tournamentId"));
		}
		
		if(request.getAttribute("tournamentId") != null){
			tournamentId = (int)(request.getAttribute("tournamentId"));
		}
		
		
		Tournament tournament = NmdQueries.findTournamentById(tournamentId);		
		User loggedUser = Util.getLoggedUser(request);		
		Registration pRegistration = NmdQueries.findRegistrationByUserAndTournament(tournament.getIdTournaments(), loggedUser.getIdUsers());	
		
		tournament = em.merge(tournament);
		loggedUser = em.merge(loggedUser);
		
		
		//---------------------------------
		//       Actions
		//---------------------------------
		
		//Player register
		if(request.getParameter("pRegister") != null && pRegistration == null){
			
			em.getTransaction().begin();
			
			pRegistration = new Registration();
			pRegistration.setUser(loggedUser);
			pRegistration.setTournament(tournament);
			pRegistration.setCreationDate(new Date());
			em.persist(pRegistration);			
			pRegistration = em.merge(pRegistration);
			
			tournament.getRegistrations().add(pRegistration);
			loggedUser.getRegistrations().add(pRegistration);
			
			em.merge(loggedUser);
			em.merge(tournament);
			request.setAttribute("successMsg", "You have successefully registered");
			
			em.getTransaction().commit();		
		}
		
		//Player unregister
		if(request.getParameter("pUnregister") != null && pRegistration != null){
			
			em.getTransaction().begin();
			
			pRegistration = em.merge(pRegistration);
			
			loggedUser.getRegistrations().remove(pRegistration);
			tournament.getRegistrations().remove(pRegistration);
			
			em.merge(loggedUser);
			em.merge(tournament);

			em.remove(em.merge(pRegistration));
			request.setAttribute("successMsg", "You have successefully unregistered");
			 
			em.getTransaction().commit();
			pRegistration=null;
		}
		
		//Clan register
		
		if(request.getParameter("cRegister") != null){	
			
			Map<String, String[]> map = request.getParameterMap();	
			Clan c = NmdQueries.findClanById(Integer.parseInt(map.get("clanId")[0]));
			c = em.merge(c);
			
			if(map.size()-3 == tournament.getFormatoftournament().getIdFormatTournaments() && !Util.isRegistered(c, tournament)){
			
				Map<String, String[]> myMap = new HashMap<String, String[]>(map);		

				myMap.remove("tournamentId");
				myMap.remove("clanId");
				myMap.remove("cRegister");
	
				logger.log(Level.INFO,"Size: "+ myMap.size() );
				for (Object key: myMap.keySet())
				{	
					User u = NmdQueries.findUserById(Integer.parseInt(key.toString()));
					
					em.getTransaction().begin();
					
					Registration r = new Registration();
					r.setUser(u);
					r.setTournament(tournament);
					r.setClan(c);
					r.setCreationDate(new Date());
					em.persist(r);
					r = em.merge(r);
					
					c.getRegistrations().add(r);
					u.getRegistrations().add(r);
					tournament.getRegistrations().add(r);
					
					em.merge(u);
					em.merge(tournament);
					em.merge(c);
					
					request.setAttribute("successMsg", "Your clan has successfully registered");
					em.getTransaction().commit();					
				}


			}else{
				request.setAttribute("errMsg", "You can only add " + tournament.getFormatoftournament().getIdFormatTournaments() + " players by clan");
			}			
		}
		
		//Clan unregister
		
		if(request.getParameter("cUnregister") != null){
			
			em.getTransaction().begin();
			
			Clan c = NmdQueries.findClanById(Integer.parseInt(request.getParameter("clanId")));
			c = em.merge(c);
			
			for(Registration r : c.getRegistrations()){
				
				r = em.merge(r);
				
				User u = r.getUser();
				
				u.getRegistrations().remove(r);
			
				Tournament t = r.getTournament();
				
				t.getRegistrations().remove(r);
				
				em.merge(u);
				em.merge(t);
				em.remove(r);
			}
			em.getTransaction().commit();
		}
		
		
		//---------------------------------
		//      Setting lists and attributes
		//---------------------------------
		
		//If tournament type is "Single Player"(1)
		if(tournament.getTypeoftournament().getIdTypeOfTournaments() == 1){
			
			request.setAttribute("loggedUserHasGame", Util.hasGame(loggedUser, tournament.getGame()));
		}		
		
		//If tournament of type "Clans"(2)
		if(tournament.getTypeoftournament().getIdTypeOfTournaments() == 2){
		
			List<Clan> unregisteredClans = new ArrayList<Clan>();
			List<Clan> registeredClans = new ArrayList<Clan>();
			
			Util.ClanLists(loggedUser, tournament, unregisteredClans, registeredClans);
			
			request.setAttribute("unregisteredClans", unregisteredClans);
			request.setAttribute("registeredClans", registeredClans);
		}
		pRegistration = NmdQueries.findRegistrationByUserAndTournament(tournament.getIdTournaments(), loggedUser.getIdUsers());
		request.setAttribute("pRegistration", pRegistration);
		request.setAttribute("tournament", tournament);
		request.setAttribute("loggedUser", loggedUser);
		
		em.close();
		doGet(request, response);
	}
}
