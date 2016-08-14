package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mt.connection.EMF;
import mt.entities.Formatoftournament;
import mt.entities.Game;
import mt.entities.Location;
import mt.entities.Tournament;
import mt.entities.Typeoftournament;
import mt.entities.User;
import mt.util.Util;
import mt.validation.LocationCreation;
import mt.validation.LocationValidation;
import mt.validation.TournamentCreation;
import mt.validation.TournamentValidation;

/**
 * Servlet implementation class SrvTournament
 */
@WebServlet("/tournamentcreation")
public class SrvTournamentCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrvTournamentCreation() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		

		ServletContext context = request.getSession().getServletContext();	

		request.setAttribute("listFormatOfTournament", context.getAttribute("formatOfTournament"));
		request.setAttribute("listTypeOfTournament", context.getAttribute("typeOfTournament"));
		request.setAttribute("listGames", context.getAttribute("games"));

		this.getServletContext().getRequestDispatcher("/WEB-INF/tournamentcreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(TournamentValidation.validate(request)){
			Tournament tournament = new Tournament();
			TournamentCreation.create(request, tournament);

			EMF.getEMF();
			EntityManager em = EMF.getEM();
			
			em.getTransaction().begin();

			if(!tournament.getOnline()&& LocationValidation.validate(request)){
				Location location = new Location();
				LocationCreation.create(request, location);
				
				em.persist(location);
				tournament.setLocation(location);				
			}
			
			ServletContext context = request.getSession().getServletContext();
			
			List<Game> gl = new ArrayList<Game>((List<Game>)context.getAttribute("games"));
			Game g  = new Game();
			g = gl.get(Integer.parseInt(request.getParameter("gameTournament")));
			em.merge(g);
			tournament.setGame(g);
			
			List<Typeoftournament> tl = new ArrayList<Typeoftournament>((List<Typeoftournament>)context.getAttribute("typeOfTournament"));
			Typeoftournament t = new Typeoftournament();
			t = tl.get(Integer.parseInt(request.getParameter("typeTournament")));
			em.merge(t);
			tournament.setTypeoftournament(t);
			
			List<Formatoftournament> fl = new ArrayList<Formatoftournament>((List<Formatoftournament>)context.getAttribute("formatOfTournament"));
			Formatoftournament f = new Formatoftournament();
			f = fl.get(Integer.parseInt(request.getParameter("formatTournament")));
			em.merge(f);
			tournament.setFormatoftournament(f);
			
			User u = new User();
			u = Util.getLoggedUser(request);
			em.merge(u);
			tournament.setUser(u);
			
			em.persist(tournament);			
			
			em.getTransaction().commit();
			em.close();
		}


		response.sendRedirect("tournamentslist");
	}

}
