package mt.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mt.util.NmdQueries;

/**
 * Servlet implementation class index
 */
@WebServlet("")
public class SrvIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvIndex() {
        super();
        // TODO Auto-generated constructor stub
    }    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		ServletContext context = getServletContext();
		context.setAttribute("userRoles", NmdQueries.findAllUserroles());
		context.setAttribute("platforms", NmdQueries.findAllPlatforms());
		context.setAttribute("games", NmdQueries.findAllGames());
		context.setAttribute("formatOfTournament", NmdQueries.findAllFormatOfTournament());
		context.setAttribute("typeOfTournament", NmdQueries.findAllTypeOfTournament());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
