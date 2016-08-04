package mt.util;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.Platform;
import mt.entities.User;
import mt.entities.Userrole;
import mt.servlets.Game;



public final class NmdQueries {
	
	private static final Logger logger = Logger.getLogger(NmdQueries.class);
	
	//---------------------------------------------------------
	//Queries USERS
	//---------------------------------------------------------

	//Get user login with password and email in DB
	public static User userLogin(String email, String pass){
		User user = new User();
		try{
			user = (User)EMF.getEM().createNamedQuery("User.login").setParameter("email", email).setParameter("pass", pass).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	
	//---------------------------------------------------------
	//Queries USERS
	//---------------------------------------------------------
	
	//Get userRole in DB by id
	public static Userrole findUserrole(int id, EntityManager em){
		return em.find(Userrole.class, id);
	}
	//Get all userRoles 
	public static List<Userrole> findAllUserroles(){
		List<Userrole> userRoles = null;
		try{
			userRoles = EMF.getEM().createNamedQuery("Userrole.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return userRoles;
	}
	
	//---------------------------------------------------------
	//Queries GAMEACCOUNT
	//---------------------------------------------------------
	
	//Get gameAccount by id
	public static Gameaccount findGameAccount(int idGameAccounts){
		Gameaccount gameAccount = new Gameaccount();
		try{
			gameAccount = (Gameaccount)EMF.getEM().createNamedQuery("Gameaccount.findByIdGameaccount").setParameter("idGameAccounts", idGameAccounts).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return gameAccount;
	}
	//Get list gameAccounts by id user
	public static List<Gameaccount> findGameAccounts(int idUsers){
		List<Gameaccount> gameAccounts = new ArrayList<Gameaccount>();
		try{
			gameAccounts = EMF.getEM().createNamedQuery("Gameaccount.findByUser").setParameter("idUsers", idUsers).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return gameAccounts;
	}
	
	//---------------------------------------------------------
	//Queries GAMES
	//---------------------------------------------------------
	
	//Get all games
	public static List<Game> findAllGames(){
		List<Game> games = new ArrayList<Game>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return games;
	}
	//Get list game by id
	public static List<Game> findByIdPlatform(int idPlatforms){
		List<Game> games = new ArrayList<Game>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findByPlatform").setParameter("idPlatforms", idPlatforms).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return games;
	}
	
	//---------------------------------------------------------
	//Queries PLATFORMS
	//---------------------------------------------------------
	
	//Get list plaftorms
	public static List<Platform> findAllPlatforms(){
		List<Platform> platforms = null;
		try{
			platforms = EMF.getEM().createNamedQuery("Platform.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return platforms;
	}
}
