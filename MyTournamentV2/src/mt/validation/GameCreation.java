package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Game;
import mt.util.NmdQueries;

/**
 * @author Lucas Giunta
 *
 */
public final class GameCreation {
	/**
	 * create object Game
	 * @param request http request
	 * @param game object Game
	 */
	public static void create(HttpServletRequest request, Game game){
		System.out.println(request.getParameter("namePlatforms"));
		game.setName(request.getParameter("nameGames"));
		game.setActive(true);
		game.setPlatform(NmdQueries.findPlatformById(Integer.parseInt(request.getParameter("namePlatforms"))));
				
	}
}
