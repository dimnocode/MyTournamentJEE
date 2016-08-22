package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Formatoftournament;

/**
 * @author Lucas Giunta
 *
 */
public class FormatoftournamentCreation {
	/**
	 * create object Formatoftournament
	 * @param request http request
	 * @param format object Formatoftournament
	 */
	public static void create(HttpServletRequest request, Formatoftournament format){
		format.setName(request.getParameter("nameFormatoftournament"));
		format.setActive(true);
	}
}
