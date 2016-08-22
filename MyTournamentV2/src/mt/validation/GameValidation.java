package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Lucas Giunta
 *
 */
public class GameValidation {
	private static final Logger logger = Logger.getLogger(GameValidation.class);

	/**
	 * method for to check @param request match with regex
	 * @param request http request
	 * @return true if all paramater is validate or false
	 */
	public static boolean validate(HttpServletRequest request){
		if(!request.getParameter("nameGames").matches("[a-zA-Z0-9-\\s]{4,20}")){
			logger.log(Level.WARN, "Game NOT validated for creation" );
			return false;
		}else{
			logger.log(Level.INFO, "Game validated for creation" );
			return true;
		}
	}
}
