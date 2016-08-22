package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Lucas Giunta
 *
 */
public final class LocationValidation {
	
	private static final Logger logger = Logger.getLogger(TournamentValidation.class);

	/**
	 * method for to check @param request match with regex
	 * @param request http request
	 * @return true if all paramater is validate or false
	 */
	public static boolean validate(HttpServletRequest request){
		if(				
				!request.getParameter("street").matches("^[\\sa-zA-Z0-9,-]{4,20}$") ||
				!request.getParameter("town").matches("[a-zA-Z-\\s]{4,20}") ||
				!request.getParameter("zipcode").matches("[a-zA-Z0-9-\\s]{4,20}") ||
				!request.getParameter("country").matches("[a-zA-Z-\\s]{4,20}")

			){
			logger.log(Level.WARN, "Location NOT validated for creation" );
			return false;
		}else{
			logger.log(Level.INFO, "Location validated for creation" );
			return true;
		}
	}
}
