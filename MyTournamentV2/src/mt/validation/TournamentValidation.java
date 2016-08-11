package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.util.Util;


public final class TournamentValidation {
	
	private static final Logger logger = Logger.getLogger(TournamentValidation.class);

	public static boolean validate(HttpServletRequest request){
		if(
				!request.getParameter("nameTournament").matches("[a-zA-Z-\\s]{4,20}") ||
				!request.getParameter("gameTournament").matches("\\d+")||
				!request.getParameter("typeTournament").matches("\\d+") ||
				!request.getParameter("formatTournament").matches("\\d+")||
				!request.getParameter("maxPlayerTournament").matches("\\d+") ||
				!request.getParameter("priceTournament").matches("\\d+") ||
				Util.stringToDate(request.getParameter("startDateTournament")) == null ||
				Util.stringToDate(request.getParameter("endDateTournament")) == null ||
				(request.getParameter("onlineTournament") == null) && (
				!request.getParameter("streetTournament").matches("[a-zA-Z-\\s]{4,20}") ||
				!request.getParameter("cityTournament").matches("[a-zA-Z-\\s]{4,20}") ||
				!request.getParameter("zipcodeTournament").matches("[a-zA-Z-\\s]{4,20}") ||
				!request.getParameter("countryTournament").matches("[a-zA-Z-\\s]{4,20}"))
				
			){
			return false;
		}
		else{
			logger.log(Level.INFO, "Tournament validated for creation" );
			return true;
		}
	}

}