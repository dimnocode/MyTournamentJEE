package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Gameaccount;

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
		
		Gameaccount gameaccount = new Gameaccount();
		try {
			gameaccount = find(Integer.parseInt(request.getParameter("idGameAccounts")));
		} catch (Exception e) {
			logger.log(Level.WARN, e.getMessage());
			response.sendRedirect("error");
		}
		request.setAttribute("gameaccount", gameaccount);
		request.setAttribute("listGame", findByIdPlatform(gameaccount.getPlatform().getIdPlatforms()));
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
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
	
	private Gameaccount find(int idGameAccounts){
		Gameaccount gameAccount = new Gameaccount();
		try{
			gameAccount = (Gameaccount)EMF.getEM().createNamedQuery("Gameaccount.findByIdGameaccount").setParameter("idGameAccounts", idGameAccounts).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return gameAccount;
	}
	private List<Game> findByIdPlatform(int idPlatforms){
		List<Game> games = new ArrayList<Game>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findByPlatform").setParameter("idPlatforms", idPlatforms).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return games;
	}
	
}
