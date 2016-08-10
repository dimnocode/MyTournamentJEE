package mt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Game;
import mt.entities.Gameaccount;
import mt.util.NmdQueries;
import mt.util.Util;

/**
 * Servlet implementation class Game
 */
@WebServlet("/game")
public class SrvGameAccountGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvGameAccountGames.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvGameAccountGames() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idGameAccount = request.getParameter("idGameAccounts");
		System.out.println(idGameAccount);
		if(Util.getLoggedUser(request) != null){
			if(idGameAccount != null){
				Gameaccount gameaccount = new Gameaccount();
				try {
					gameaccount = NmdQueries.findGameAccount(Integer.parseInt(idGameAccount));
				} catch (Exception e) {
					logger.log(Level.WARN, e.getMessage());
					response.sendRedirect("error");
				}
				request.setAttribute("gameaccount", gameaccount);
				request.setAttribute("listGame", NmdQueries.findGamesByPlatform(gameaccount.getPlatform().getIdPlatforms(),gameaccount.getIdGameAccounts()));
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
			}
			else{
				response.sendRedirect("error");
			}
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
		
		
		String btnGameRemove = request.getParameter("btnGameRemove");
		
		if(btnGameRemove != null){
			int idGame = 0;
			int idGameAccount = 0;
			try{
				idGame = Integer.parseInt(request.getParameter("idGames"));
				idGameAccount = Integer.parseInt(request.getParameter("idGameAccounts"));
			}catch(Exception e){
				logger.log(Level.WARN, e.getMessage());
			}
			Gameaccount ga = NmdQueries.findGameAccount(idGameAccount);
			Game g = NmdQueries.findGameById(idGame);
			
			Game game = new Game();
			Gameaccount gameaccount = new Gameaccount();
			
			for(Game item : ga.getGames()){
				if(item.getIdGames() == g.getIdGames()){
					game = item;
				}	
			}
			for(Gameaccount item : g.getGameaccounts()){
				if(item.getIdGameAccounts() == ga.getIdGameAccounts()){
					gameaccount = item;
				}	
			}
			logger.log(Level.INFO,"List game of gameAccount: "+ ga.getGames().size());
			
			try{
				em.getTransaction().begin();
				ga.getGames().remove(game);
				g.getGameaccounts().remove(gameaccount);
				em.merge(ga);
				em.merge(g);
				logger.log(Level.INFO,"List game of gameAccount: "+ gameaccount.getGames().size());
				logger.log(Level.INFO,"Game and GameAccount removed ");
				em.getTransaction().commit();
			}catch(Exception e){
				logger.log(Level.WARN, e.getMessage());
			}finally {
				em.close();
			}
			doGet(request, response);
		}
		else{
			Map<String, String[]> map = request.getParameterMap();
			int idGameAccount = 0;
			try{
				idGameAccount = Integer.parseInt(map.get("idGameAccounts")[0]);
			}catch(Exception e){
				logger.log(Level.WARN, e.getMessage());
			}
				
			Gameaccount ga = NmdQueries.findGameAccount(idGameAccount);
			Game g = new Game();
			Map<String, String[]> myMap = new HashMap<String, String[]>(map);
			myMap.remove("idGameAccounts");
				
			em.getTransaction().begin();
			for (Object key: myMap.keySet())
		    {
				g = NmdQueries.findGameById(Integer.parseInt(key.toString()));
				ga.getGames().add(g);
				g.getGameaccounts().add(ga);
				em.merge(g);
				em.merge(ga);
						
				logger.log(Level.INFO,"Game and GameAccount updated ");
	            logger.log(Level.INFO,"Size: "+ myMap.size() );
	        }
			em.getTransaction().commit();
			em.close();
			doGet(request, response);
		}
	}
	
	
	
	
}
