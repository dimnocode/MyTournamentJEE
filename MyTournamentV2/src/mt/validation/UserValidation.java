package mt.validation;

import javax.servlet.http.HttpServletRequest;

public final class UserValidation {
	
	public static boolean validate(HttpServletRequest request){
				
		if(
				!request.getParameter("nameUser").matches("^[a-zA-Z_-]{3,20}$") || 
				!request.getParameter("firstnameUser").matches("^[a-zA-Z_-]{3,20}$") ||
				!request.getParameter("emailUser").matches("^[^-_()!{}$&µ£=:+;,/\\.][a-zA-Z-.]+@[a-zA-Z-.]+\\.[a-zA-Z]{1,100}$")||
				!request.getParameter("pseudoUser").matches("^[a-z0-9]+$") ||
				!request.getParameter("phoneUser").matches("(?=.*[a-zA-Z][0-9]).{3,20}$")
				
				
		){
			return false;
		}

		
<<<<<<< HEAD
=======
		if(request.getParameter("nameUser").matches("(?=.*[a-zA-Z]).{3,20}$")){
			
		}
		request.getParameter("firstnameUser");
		request.getParameter("emailUser");
		request.getParameter("phoneUser");
>>>>>>> refs/remotes/origin/master
		request.getParameter("dobUser");
		request.getParameter("passUser");
		request.getParameter("confirmUser");
		
		
		
		return false;
		
	}
		
}