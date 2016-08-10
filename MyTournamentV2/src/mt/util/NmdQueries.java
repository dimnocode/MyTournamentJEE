package mt.util;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Formatoftournament;
import mt.entities.Game;
import mt.entities.Gameaccount;
import mt.entities.Platform;
import mt.entities.Typeoftournament;
import mt.entities.User;
import mt.entities.Userrole;
import mt.servlets.SrvGameAccountGames;



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
	
	//Get game by Id
	public static Game findGameById(int idGames){
		Game game = new Game();
		try{
			game = (Game) EMF.getEM().createNamedQuery("Game.findById").setParameter("idGames", idGames).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return game;
	}
	//Get all games
	public static List<SrvGameAccountGames> findAllGames(){
		List<SrvGameAccountGames> games = new ArrayList<SrvGameAccountGames>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return games;
	}
	//Get list game by id
	public static List<SrvGameAccountGames> findGamesByPlatform(int idPlatforms, int idGameAccounts){
		List<SrvGameAccountGames> games = new ArrayList<SrvGameAccountGames>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findByPlatform").setParameter("idPlatforms", idPlatforms).setParameter("idGameAccounts", idGameAccounts).getResultList();
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
	
	//---------------------------------------------------------
	//Queries TYPE OF TOURNAMENTS
	//---------------------------------------------------------
	
	//Get list type of tournament
	public static List<Typeoftournament> findAllTypeOfTournament(){
		List<Typeoftournament> typeOfTournament = null;
		try{
			typeOfTournament = EMF.getEM().createNamedQuery("Typeoftournament.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return typeOfTournament;
	}
	
	//---------------------------------------------------------
	//Queries FORMAT OF TOURNAMENT
	//---------------------------------------------------------
		
	//Get list format or tournament
	public static List<Formatoftournament> findAllFormatOfTournament(){
		List<Formatoftournament> FormatOfTournament = null;
		try{
			FormatOfTournament = EMF.getEM().createNamedQuery("Formatoftournament.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return FormatOfTournament;
	}
}
