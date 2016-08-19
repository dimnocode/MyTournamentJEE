package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FormatoftournamentValidation {
	private static final Logger logger = Logger.getLogger(FormatoftournamentValidation.class);

	public static boolean validate(HttpServletRequest request){
		if(!request.getParameter("nameFormatoftournament").matches("[a-zA-Z0-9-\\s]{4,20}")){
			logger.log(Level.WARN, "Format of tournament NOT validated for creation");
			return false;
		}
		else{
			logger.log(Level.INFO, "Format of tournament validated for creation" );
			return true;
		}
	}
}
