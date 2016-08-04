package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.connection.EMF;
import mt.entities.User;
import mt.util.Hashing;
import mt.util.NmdQueries;
import mt.util.Util;

public final class UserCreation{
	
	public static void create(HttpServletRequest request, User user){
		
		user.setName(request.getParameter("nameUser"));
		user.setFirstname(request.getParameter("firstnameUser"));
		user.setEmail(request.getParameter("emailUser"));
		user.setPseudo(request.getParameter("pseudoUser"));
		user.setPhoneNumber(request.getParameter("phoneUser"));
		user.setPassword(Hashing.hash(request.getParameter("passUser")));
		user.setDob(Util.stringToDate(request.getParameter("dobUser")));
		user.setCreationDate(new Date());
		user.setActive(true);
		user.setUserrole(NmdQueries.findUserrole(2,EMF.getEM()));
	}
	
	
}
