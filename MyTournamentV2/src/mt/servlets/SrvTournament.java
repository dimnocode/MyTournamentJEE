package mt.servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mt.connection.EMF;
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
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/tournament.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tournamentId = Integer.parseInt(request.getParameter("tournamentId"));		
		Tournament tournament = NmdQueries.findTournamentById(tournamentId);
		User loggedUser = Util.getLoggedUser(request);
		
		long isUserRegistered = NmdQueries.isUserRegistered(tournament.getIdTournaments(), loggedUser.getIdUsers());
		
		
		request.setAttribute("tournament", tournament);
		request.setAttribute("loggedUser", loggedUser);		
		request.setAttribute("isUserRegistered", isUserRegistered);
		
		//Nmd query to check if user is already registered
		//Nmd query to check if clan is already registered
				
		//Player registration
		if(request.getParameter("pRegister") != null && isUserRegistered == 0){
			EMF.getEMF();
			EntityManager em = EMF.getEM();
			
			em.getTransaction().begin();
			
			em.merge(loggedUser);
			em.merge(tournament);
			
			Registration registration = new Registration();
			registration.setUser(loggedUser);
			registration.setTournament(tournament);
			registration.setCreationDate(new Date());
			em.persist(registration);
			
			em.merge(registration);
			
			tournament.addRegistration(registration);
			loggedUser.addRegistration(registration);
			
			em.merge(loggedUser);
			em.merge(tournament);
			 
			em.getTransaction().commit();
			
			isUserRegistered = 1;
			request.setAttribute("isUserRegistered", isUserRegistered);
		}
		
		
		System.out.println(isUserRegistered);
		doGet(request, response);
	}

}
