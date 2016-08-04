package mt.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.entities.Gameaccount;
import mt.util.NmdQueries;
import mt.util.Util;

/**
 * Servlet implementation class Game
 */
@WebServlet("/game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Game.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(Util.getLoggedUser(request) != null ){
			Gameaccount gameaccount = new Gameaccount();
			try {
				gameaccount = NmdQueries.findGameAccount(Integer.parseInt(request.getParameter("idGameAccounts")));
			} catch (Exception e) {
				logger.log(Level.WARN, e.getMessage());
				response.sendRedirect("error");
			}
			request.setAttribute("gameaccount", gameaccount);
			request.setAttribute("listGame", NmdQueries.findByIdPlatform(gameaccount.getPlatform().getIdPlatforms()));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
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
		
		Map<String, String[]> map = request.getParameterMap();
		for (Object key: map.keySet())
	    {
	            String keyStr = (String) key;
	            String[] value = (String[])map.get(keyStr);
	            String val = (Arrays.toString(value));
	            val = val.substring(1,val.length()-1);
	            logger.log(Level.INFO,"Key " + (String)key + "   :   " + val );
	    }
		
		doGet(request, response);
	}
	
	
	
	
}
