package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Formatoftournament;

public class FormatoftournamentCreation {
	public static void create(HttpServletRequest request, Formatoftournament format){
		format.setName(request.getParameter("nameFormatoftournament"));
		format.setActive(true);
	}
}
