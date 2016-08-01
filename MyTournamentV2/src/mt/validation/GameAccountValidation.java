package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;



public class GameAccountValidation {

	private static final Logger logger = Logger.getLogger(GameAccountValidation.class);
	
	public static boolean validate(HttpServletRequest request){
		
		if(!request.getParameter("nameGameAccount").matches("^[a-z0-9]{4,20}$")){
			return false;
		}
		
		
		logger.log(Level.INFO, "GameAccount validated" );
		return true;
		
	}
	
}
