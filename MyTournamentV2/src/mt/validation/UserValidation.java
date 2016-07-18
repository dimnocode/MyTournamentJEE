package mt.validation;

import javax.servlet.http.HttpServletRequest;

public final class UserValidation {
	
	public static boolean validate(HttpServletRequest request){
		
		if(request.getParameter("nameUser").matches("(?=.*[a-zA-Z]).{3,20}$")){
			
		}
		request.getParameter("firstnameUser");
		request.getParameter("emailUser");
		request.getParameter("phoneUser");
		request.getParameter("dobUser");
		request.getParameter("passUser");
		request.getParameter("confirmUser");
		
		
		
		return false;
		
	}
		
}