package mt.validation;


import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.Platform;
import mt.entities.User;



public class GameAccountCreation {
	
	public static void create(HttpServletRequest request, Gameaccount gameAccount){
		HttpSession session = request.getSession();
		
		gameAccount.setName(request.getParameter("nameGameAccount"));
		gameAccount.setActive(true);
		gameAccount.setPlatform(findPlatform(request.getParameter("namePlateform")));	
		gameAccount.setUser((User)session.getAttribute("loggedUser"));
				
	}
	
	private static Platform findPlatform(String id){
		System.out.println(id);
		int idPlatform = Integer.parseInt(id);
		Platform plateform = new Platform();
		try{
			plateform = (Platform)EMF.getEM().createNamedQuery("Platform.find").setParameter("idPlatforms", idPlatform).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return plateform;
	}
}
