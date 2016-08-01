package mt.validation;


import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.Gameaccountplatform;
import mt.entities.User;



public class GameAccountCreation {
	
	public static void create(HttpServletRequest request, Gameaccount gameAccount){
		HttpSession session = request.getSession();
		
		gameAccount.setName(request.getParameter("nameGameAccount"));
		gameAccount.setActive(true);
		gameAccount.setGameaccountplatform(findGameaccountplatform(request.getParameter("namePlateform")));	
		gameAccount.setUser((User)session.getAttribute("loggedUser"));
		
		
	}
	
	private static Gameaccountplatform findGameaccountplatform(String id){
		System.out.println(id);
		int idGameAccountPlatforms = Integer.parseInt(id);
		Gameaccountplatform plateform = new Gameaccountplatform();
		try{
			plateform = (Gameaccountplatform)EMF.getEM().createNamedQuery("Gameaccountplatform.find").setParameter("idGameAccountPlatforms", idGameAccountPlatforms).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return plateform;
	}
}
