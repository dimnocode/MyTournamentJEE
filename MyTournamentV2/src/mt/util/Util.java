package mt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.entities.Clan;
import mt.entities.Game;
import mt.entities.Gameaccount;
import mt.entities.Registration;
import mt.entities.Tournament;
import mt.entities.User;
import mt.entities.Usersclan;

/**
 * @author DIm
 *
 */

public final class Util {

	/**
	 *  Convert a string to date 
	 * @param dateString String format : "yyyy-MM-dd"
	 * @return Returns date if valid else return null
	 */
	public static Date stringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Convert a string to date and time
	 * @param dateString format : "yyyy-MM-dd' 'HH:mm:ss"
	 * @return Returns #date if valid else return null
	 */
	public static Date stringToDateTime(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		try {
			Date date = formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Returns the user stored in HttpSession
	/**
	 * Get the logged user in session
	 * @param request HttpRequest
	 * @return User if in session else null
	 */
	public static User getLoggedUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loggedUser");

		return user;
	}

	// Returns true if user has the game in one of his gameaccounts
	/**
	 * Checks if a user have a game in one of his active game accounts
	 * @param u Object of type User
	 * @param g Object of type Game
	 * @return Returns true if user has game in one of his active game accounts
	 */
	public static boolean hasGame(User u, Game g) {

		for (Gameaccount ga : u.getGameaccounts()) {
			//Ajouter filtre platform
			if (ga.getActive() && ga.getGames().contains(g)) {
				return true;
			}
		}
		return false;
	}

	// Returns true if user is already registered in tournament
	/**
	 * Returns true if user is already registered in tournament
	 * @param u Object of type User
	 * @param t Object of type Tournament
	 * @return returns true if a user registration is found in a tournament registrations list else returns false
	 */
	public static boolean isRegistered(User u, Tournament t){ 
		for (Registration r : u.getRegistrations()) {
			if (t.getRegistrations().contains(r)) {
				return true;
			}
		}
		return false;
	}

	// Returns true if a clan member is already registered in tournament
	/**
	 * Returns true if a clan member is already registered in tournament
	 * @param c Object of type Clan
	 * @param t Object of type Tournament
	 * @return returns true if a clan registration is found in a tournament registrations list else returns false
	 */
	public static boolean isRegistered(Clan c, Tournament t){

		for (Registration r : t.getRegistrations()) {
			if (c.getRegistrations().contains(r)) {
				return true;
			}
		}
		return false;
	}


	// Returns true if tournament has enough active players that have the game
	/**
	 * Checks if a clan has enough valid players in it to register for specific tournament
	 * Checks : if user has game, if user isn't already registered in tournament (through other clan), if user isn't deactivated in clan.
	 * @param c Object of type Clan
	 * @param t Object of type Tournament
	 * @return Returns true if number of valid players id superior or equal to tournament format id 
	 */
	public static boolean hasEnoughPlayers(Clan c, Tournament t) {
		int count = 0;

		for (Usersclan uc : c.getUsersclans()) {
			if (hasGame(uc.getUser(), t.getGame()) && !isRegistered(uc.getUser(), t) && uc.getRemovedDateTime() == null) {
				count++;
			}
		}
		return count >= t.getFormatoftournament().getIdFormatTournaments();
	}
}
