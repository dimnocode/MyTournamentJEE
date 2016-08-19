package mt.validation;

import javax.servlet.http.HttpServletRequest;
import mt.entities.Typeoftournament;

public class TypeoftournamentCreation {
	public static void create(HttpServletRequest request, Typeoftournament type){
		type.setName(request.getParameter("nameTypeoftournament"));
		type.setActive(true);
	}
}
