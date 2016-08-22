package mt.util;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Clan;
import mt.entities.Formatoftournament;
import mt.entities.Game;
import mt.entities.Gameaccount;
import mt.entities.Platform;
import mt.entities.Registration;
import mt.entities.Tournament;
import mt.entities.Typeoftournament;
import mt.entities.User;
import mt.entities.Userrole;
import mt.entities.Usersclan;



/**
 * @author Lucas Giunta
 *
 */
public final class NmdQueries {

	private static final Logger logger = Logger.getLogger(NmdQueries.class);

	//---------------------------------------------------------
	//Queries USERCLAN
	//---------------------------------------------------------


	/** 
	 * Name query for get object Usersclan by @param idClan and @param idUser
	 * @param idClan this is id of clan
	 * @param idUser this id id of user
	 * @return object Usersclan or null
	 */
	public static Usersclan findUserclanByIdUserIdClan(int idClan, int idUser){
		Usersclan userClan = new Usersclan();
		try{
			userClan = (Usersclan)EMF.getEM().createNamedQuery("Usersclan.findByIdUserIdClan").setParameter("idClan", idClan).setParameter("idUser", idUser).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return userClan;
	}
	//---------------------------------------------------------
	//Queries USERS
	//---------------------------------------------------------

	//Get user login with password and email in DB
	/**
	 * Name query for get object User by @param email and @param password
	 * @param email this is email in format String
	 * @param pass this is password in format String
	 * @return object User or null
	 */
	public static User userLogin(String email, String pass){
		User user = new User();
		try{
			user = (User)EMF.getEM().createNamedQuery("User.login").setParameter("email", email).setParameter("pass", pass).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	//Get userRole in DB by id
	/**
	 * Name query for get object Userrole by @param id
	 * @param id This is id Userrole
	 * @param em This is instance of EntityManager
	 * @return object Userrole
	 */
	public static Userrole findUserrole(int id, EntityManager em){
		return em.find(Userrole.class, id); 
	}
	
	/**
	 * Name query for get object User by @param idUsers 
	 * @param idUsers This is id User
	 * @return object User or null
	 */
	public static User findUserById(int idUsers){
		User user = new User();
		try{
			user = (User) EMF.getEM().createNamedQuery("User.findById").setParameter("idUsers", idUsers).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	/**
	 * Name query for get object User by @param email and @param pseudo
	 * @param email this is email in format String
	 * @param pseudo this is pseudo in format String
	 * @return object User or null
	 */
	public static User findUserByUnique(String email, String pseudo){
		User user = new User();
		try{
			user = (User) EMF.getEM().createNamedQuery("User.findByUnique").setParameter("email", email).setParameter("pseudo", pseudo).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	 /**
	  * Name query for get object User by @param email or @param pseudo
	 * @param email this is email in format String
	 * @param pseudo this is pseudo in format String
	 * @return object User or null
	 */
	public static User findUserByEmailOrPseudo(String email, String pseudo){
			User user = new User();
			try{
				user = (User) EMF.getEM().createNamedQuery("User.findByEmailOrPseudo").setParameter("email", email).setParameter("pseudo", pseudo).getSingleResult();
			}catch(NoResultException e){
				return null;
			}
			return user;
		}
	//Get all userRoles 
	/**
	 * Name query for get all object Userrole in format List
	 * @return list of userrole or null
	 */
	public static List<Userrole> findAllUserroles(){
		List<Userrole> userRoles = null;
		try{
			userRoles = EMF.getEM().createNamedQuery("Userrole.findAll",Userrole.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return userRoles;
	}
	//---------------------------------------------------------
	//Queries CLAN
	//---------------------------------------------------------

	//Get clan by id
	/**
	 * Name query for get object Clan by @param idClans
	 * @param idClans this is id Clan
	 * @return object clan or null
	 */
	public static Clan findClanById(int idClans){
		Clan clan = new Clan();
		try{
			clan = (Clan) EMF.getEM().createNamedQuery("Clan.findById").setParameter("idClans", idClans).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return clan;
	}

	//---------------------------------------------------------
	//Queries GAMEACCOUNT
	//---------------------------------------------------------

	//Get gameAccount by id
	/**
	 * Name query for get object Gameaccount by @param idGameAccounts
	 * @param idGameAccounts this is id Gameaccount
	 * @return object Gameaccount or null
	 */
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
	/**
	 * Name query for get all object Gameaccount in format List by @param idUsers
	 * @param idUsers this is id User
	 * @return list of Gameaccount or null
	 */
	public static List<Gameaccount> findGameAccounts(int idUsers){
		List<Gameaccount> gameAccounts = new ArrayList<Gameaccount>();
		try{
			gameAccounts = EMF.getEM().createNamedQuery("Gameaccount.findByUser",Gameaccount.class).setParameter("idUsers", idUsers).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return gameAccounts;
	}

	//---------------------------------------------------------
	//Queries GAMES
	//---------------------------------------------------------

	//Get game by Id
	/**
	 * Name query for get object Game by @param idGames
	 * @param idGames this is id Game
	 * @return object game or null
	 */
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
	/**
	 * Name query for get all object Game in format List
	 * @return list of game or null
	 */
	public static List<Game> findAllGames(){
		List<Game> games = new ArrayList<Game>();
		try{
			games = EMF.getEM().createNamedQuery("Game.findAll", Game.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return games;
	}
	//Get list game by id
	/**
	 * Name query for get all object Game in format List by @param idPlatforms and @param idGameAccounts
	 * @param idPlatforms this is id Platform
	 * @param idGameAccounts this is id Gameaccount
	 * @return list of Game or null
	 */
	public static List<Game> findGamesByPlatform(int idPlatforms, int idGameAccounts){
		List<Game> game = new ArrayList<Game>();
		try{
			game = EMF.getEM().createNamedQuery("Game.findByPlatform", Game.class).setParameter("idPlatforms", idPlatforms).setParameter("idGameAccounts", idGameAccounts).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return game;
	}

	//---------------------------------------------------------
	//Queries PLATFORMS
	//---------------------------------------------------------

	//Get list plaftorms
	/**
	 * Name query for get all object Platform in format List
	 * @return lit of Platform or null
	 */
	public static List<Platform> findAllPlatforms(){
		List<Platform> platforms = null;
		try{
			platforms = EMF.getEM().createNamedQuery("Platform.findAll",Platform.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return platforms;
	}
	/**
	 * Name query for get object Platform by @param idPlatforms
	 * @param idPlatforms this is id Platform
	 * @return object Platform or null
	 */
	public static Platform findPlatformById(int idPlatforms){
		Platform platform = null;
		try{
			platform = EMF.getEM().createNamedQuery("Platform.find",Platform.class).setParameter("idPlatforms", idPlatforms).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return platform;
	}
	//---------------------------------------------------------
	//Queries TYPE OF TOURNAMENTS
	//---------------------------------------------------------

	//Get list type of tournament
	/**
	 * Name query for get all object Typeoftournament in format List
	 * @return list of Typeoftournament or null
	 */
	public static List<Typeoftournament> findAllTypeOfTournament(){
		List<Typeoftournament> typeOfTournament = null;
		try{
			typeOfTournament = EMF.getEM().createNamedQuery("Typeoftournament.findAll",Typeoftournament.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return typeOfTournament;
	}
	/**
	 * Name query for get object Typeoftournament by @param idTypeOfTournaments
	 * @param idTypeOfTournaments this is id Typeoftournament
	 * @return object Typeoftournament or null
	 */
	public static Typeoftournament findTypeOfTournamentById(int idTypeOfTournaments){
		Typeoftournament typeOfTournament = null;
		try{
			typeOfTournament = EMF.getEM().createNamedQuery("Typeoftournament.findById",Typeoftournament.class).setParameter("idTypeOfTournaments", idTypeOfTournaments).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return typeOfTournament;
	}
	//---------------------------------------------------------
	//Queries FORMAT OF TOURNAMENT
	//---------------------------------------------------------

	//Get list format or tournament
	/**
	 * Name query for get all object Formatoftournament in format List
	 * @return list of Formatoftournament or null
	 */
	public static List<Formatoftournament> findAllFormatOfTournament(){
		List<Formatoftournament> FormatOfTournament = null;
		try{
			FormatOfTournament = EMF.getEM().createNamedQuery("Formatoftournament.findAll",Formatoftournament.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return FormatOfTournament;
	}
	/**
	 * Name query for get object Formatoftournament by @param idFormatTournaments
	 * @param idFormatTournaments this is id Formatoftournament
	 * @return object Formatoftournament or null
	 */
	public static Formatoftournament findFormatoftournamentById(int idFormatTournaments){
		Formatoftournament format = null;
		try{
			format = EMF.getEM().createNamedQuery("Formatoftournament.findById",Formatoftournament.class).setParameter("idFormatTournaments", idFormatTournaments).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return format;
	}
	//---------------------------------------------------------
	//Queries TOURNAMENT
	//---------------------------------------------------------

	//Get list of tournaments
	/**
	 * Name query for get all object Tournament in format List
	 * @return list of Tournament or null
	 */
	public static List<Tournament> findAllTournaments(){
		List<Tournament> tournaments = new ArrayList<Tournament>();
		try{
			tournaments = EMF.getEM().createNamedQuery("Tournament.findAll",Tournament.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return tournaments;
	}

	//Get tournament by id
	/**
	 * Name query for get object Tournament by @param idTournaments
	 * @param idTournaments this is id Tournament
	 * @return object Tournament or null
	 */
	public static Tournament findTournamentById(int idTournaments){
		Tournament tournament = new Tournament();
		try{
			tournament = (Tournament) EMF.getEM().createNamedQuery("Tournament.findById").setParameter("idTournaments", idTournaments).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return tournament;
	}

	//---------------------------------------------------------
	//Queries REGISTRATION
	//---------------------------------------------------------

	//Get list of registrations
	/**
	 * Name query for get all object Registration in format List
	 * @return list of Registration or null
	 */
	public static List<Registration> findAllRegistrations(){
		List<Registration> registrations = new ArrayList<Registration>();
		try{
			registrations = EMF.getEM().createNamedQuery("Registration.findAll",Registration.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return registrations;
	}

	//Get registration by user and tournament
	/**
	 * Name query for get object Registration by @param idTournament and @param idUser
	 * @param idTournament this is id Tournament
	 * @param idUser this is id User
	 * @return object Registration or null
	 */
	public static Registration findRegistrationByUserAndTournament(int idTournament, int idUser){
		Registration registration = new Registration();
		try{
			registration = (Registration) EMF.getEM().createNamedQuery("Registration.findByUserAndTournament").setParameter("idTournament", idTournament).setParameter("idUser", idUser).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return registration;
	}
}
