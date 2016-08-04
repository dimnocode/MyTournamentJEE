package mt.validation;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.util.Util;

public final class UserValidation {
	
	private static final Logger logger = Logger.getLogger(UserValidation.class);
	
	public static boolean validate(HttpServletRequest request){
				
		if(
				!request.getParameter("nameUser").matches("^[a-zA-Z-\\s]{3,20}$") || 
				!request.getParameter("firstnameUser").matches("^[a-zA-Z-\\s]{3,20}$") ||
				!request.getParameter("emailUser").matches("^[^-_()!{}$&µ£=:+;,/\\.][a-zA-Z-.]+@[a-zA-Z-.]+\\.[a-zA-Z]{1,100}$")||
				!request.getParameter("pseudoUser").matches("^[a-z0-9]{4,20}$") ||
				!request.getParameter("phoneUser").matches("^\\d{4}/\\d{3}-\\d{3}$") ||
				!request.getParameter("passUser").matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([A-Za-z0-9]){3,20}$")
				
		){
			return false;
		}
		
		if (Util.stringToDate(request.getParameter("dobUser")) == null){
			return false;
		}
		
		
		if (!request.getParameter("passUser").equals(request.getParameter("confirmUser"))){
			return false;
		}
				
		logger.log(Level.INFO, "User validated" );
		return true;
		
	}
		
}