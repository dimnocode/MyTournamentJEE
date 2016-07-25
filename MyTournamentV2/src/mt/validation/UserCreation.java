package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.entities.User;
import mt.util.Hashing;
import mt.util.Util;

public final class UserCreation {
	
	public static void create(HttpServletRequest request, User user){
		
		user.setName(request.getParameter("nameUser"));
		user.setFirstname(request.getParameter("firstnameUser"));
		user.setEmail(request.getParameter("emailUser"));
		user.setPseudo(request.getParameter("pseudoUser"));
		user.setPassword(Hashing.hash(request.getParameter("passwordUser")));
		user.setDob(Util.stringToDate(request.getParameter("dobUser")));
		user.setCreationDate(new Date());
		
	}

}
