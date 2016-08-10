package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class ClanValidation {
private static final Logger logger = Logger.getLogger(GameAccountValidation.class);
	
	public static boolean validate(HttpServletRequest request){
		
		if(!request.getParameter("nameClan").matches("^[a-zA-Z0-9\\s]{4,20}$")){
			return false;
		}
		
		
		logger.log(Level.INFO, "Clan validated" );
		return true;
		
	}
}
