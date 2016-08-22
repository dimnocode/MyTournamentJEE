package mt.validation;

import javax.servlet.http.HttpServletRequest;
import mt.entities.Typeoftournament;

/**
 * @author Lucas Giunta
 *
 */
public class TypeoftournamentCreation {
	/**
	 * create object Typeoftournament
	 * @param request http request
	 * @param type object Typeoftournament
	 */
	public static void create(HttpServletRequest request, Typeoftournament type){
		type.setName(request.getParameter("nameTypeoftournament"));
		type.setActive(true);
	}
}
