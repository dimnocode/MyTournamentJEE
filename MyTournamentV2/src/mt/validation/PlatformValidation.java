package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Lucas Giunta
 *
 */
public final class PlatformValidation {
	private static final Logger logger = Logger.getLogger(PlatformValidation.class);

	/**
	 * method for to check @param request match with regex
	 * @param request http request
	 * @return true if all paramater is validate or false
	 */
	public static boolean validate(HttpServletRequest request){
		if(!request.getParameter("namePlatforms").matches("[a-zA-Z0-9-\\s]{4,20}")){
			logger.log(Level.WARN, "Platform NOT validated for creation");
			return false;
		}
		else{
			logger.log(Level.INFO, "Platform validated for creation" );
			return true;
		}
	}
}
