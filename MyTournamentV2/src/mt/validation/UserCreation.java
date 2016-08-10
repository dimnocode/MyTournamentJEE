package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.User;
import mt.util.Hashing;
import mt.util.NmdQueries;
import mt.util.Util;

public final class UserCreation{
	private static final Logger logger = Logger.getLogger(UserCreation.class);
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
	
	//METHODE QUI SERVIRA A UPDATE LES INFORMATION 
	public static void updateInfo(HttpServletRequest request, User user){
		user.setName(request.getParameter("nameUser"));
		user.setFirstname(request.getParameter("firstnameUser"));
		user.setEmail(request.getParameter("emailUser"));
		user.setPseudo(request.getParameter("pseudoUser"));
		user.setPhoneNumber(request.getParameter("phoneUser"));
		user.setDob(Util.stringToDate(request.getParameter("dobUser")));
	}
	//METHODE QUI SERVIRA A UPDATE LE PASSWORD
	public static boolean updatePassword(HttpServletRequest request, User user){
		if(user.getPassword().equals(Hashing.hash(request.getParameter("passUserEdit")))){
			user.setPassword(Hashing.hash(request.getParameter("newPassUserEdit")));
			logger.log(Level.INFO, "New pass: " +request.getParameter("newPassUserEdit") + " : " +  Hashing.hash(request.getParameter("newPassUserEdit")));
			return true;
		}else{
			logger.log(Level.INFO, "Your actual password is not found" );
			return false;
		}
	}
	
	
}
