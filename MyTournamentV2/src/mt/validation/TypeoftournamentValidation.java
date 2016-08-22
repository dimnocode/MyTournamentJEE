package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Lucas Giunta
 *
 */
public final class TypeoftournamentValidation {
	private static final Logger logger = Logger.getLogger(TypeoftournamentValidation.class);

	/**
	 * method for to check @param request with regex
	 * @param request http request
	 * @return true if parameter match with regex or false if not match
	 */
	public static boolean validate(HttpServletRequest request){
		if(!request.getParameter("nameTypeoftournament").matches("[a-zA-Z0-9-\\s]{4,20}")){
			logger.log(Level.WARN, "Type of tournament NOT validated for creation");
			return false;
		}
		else{
			logger.log(Level.INFO, "Type of tournament validated for creation" );
			return true;
		}
	}
}
