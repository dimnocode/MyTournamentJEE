package mt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.entities.Clan;
import mt.entities.Game;
import mt.entities.Gameaccount;
import mt.entities.Tournament;
import mt.entities.User;
import mt.entities.Usersclan;

public final class Util {

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

	public static User getLoggedUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loggedUser");

		return user;
	}

	// Returns true if user has the game in one of his gameaccounts
	public static boolean hasGame(User u, Game g) {

		for (Gameaccount ga : u.getGameaccounts()) {
			if (ga.getGames().contains(g)) {
				return true;
			}
		}
		return false;
	}

	// Returns true if tournament has enough players that have the game
	public static boolean hasEnoughPlayers(Clan c, Tournament t) {
		int count = 0;

		for (Usersclan uc : c.getUsersclans()) {
			if (hasGame(uc.getUser(), t.getGame())) {
				count++;
			}
		}
		return count >= t.getFormatoftournament().getIdFormatTournaments();
	}
}
