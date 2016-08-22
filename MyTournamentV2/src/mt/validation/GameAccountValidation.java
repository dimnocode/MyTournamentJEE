package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;



/**
 * @author Lucas Giunta
 *
 */
public class GameAccountValidation {

	private static final Logger logger = Logger.getLogger(GameAccountValidation.class);
	
	/**
	 * method for to check @param request match with regex
	 * @param request http request
	 * @return true if all paramater is validate or false
	 */
	public static boolean validate(HttpServletRequest request){
		
		if(!request.getParameter("nameGameAccount").matches("^[a-zA-Z0-9\\s]{4,20}$")){
			return false;
		}
		
		
		logger.log(Level.INFO, "GameAccount validated" );
		return true;
		
	}
	
}
