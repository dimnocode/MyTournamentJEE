package mt.validation;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.entities.Gameaccount;
import mt.entities.User;
import mt.util.NmdQueries;



public class GameAccountCreation {
	
	public static void create(HttpServletRequest request, Gameaccount gameAccount){
		HttpSession session = request.getSession();
		
		gameAccount.setName(request.getParameter("nameGameAccount"));
		gameAccount.setActive(true);
		gameAccount.setPlatform(NmdQueries.findPlatformById(Integer.parseInt(request.getParameter("namePlateform"))));	
		gameAccount.setUser((User)session.getAttribute("loggedUser"));
				
	}
}
