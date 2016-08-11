package mt.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
			
			
			ServletContext context = request.getSession().getServletContext();	
			
			request.setAttribute("listFormatOfTournament", context.getAttribute("formatOfTournament"));
			request.setAttribute("listTypeOfTournament", context.getAttribute("typeOfTournament"));
			request.setAttribute("listGames", context.getAttribute("games"));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/tournament.jsp").forward(request, response);
	
		
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
