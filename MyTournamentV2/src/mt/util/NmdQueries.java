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



public final class NmdQueries {

	private static final Logger logger = Logger.getLogger(NmdQueries.class);

	//---------------------------------------------------------
	//Queries USERCLAN
	//---------------------------------------------------------


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
	public static Userrole findUserrole(int id, EntityManager em){
		return em.find(Userrole.class, id);
	}
	public static User findUserById(int idUsers){
		User user = new User();
		try{
			user = (User) EMF.getEM().createNamedQuery("User.findById").setParameter("idUsers", idUsers).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	public static User findUserByUnique(String email, String pseudo){
		User user = new User();
		try{
			user = (User) EMF.getEM().createNamedQuery("User.findByUnique").setParameter("email", email).setParameter("pseudo", pseudo).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}
	//Get all userRoles 
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
	public static List<Platform> findAllPlatforms(){
		List<Platform> platforms = null;
		try{
			platforms = EMF.getEM().createNamedQuery("Platform.findAll",Platform.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return platforms;
	}
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
	public static List<Typeoftournament> findAllTypeOfTournament(){
		List<Typeoftournament> typeOfTournament = null;
		try{
			typeOfTournament = EMF.getEM().createNamedQuery("Typeoftournament.findAll",Typeoftournament.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return typeOfTournament;
	}
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
	public static List<Formatoftournament> findAllFormatOfTournament(){
		List<Formatoftournament> FormatOfTournament = null;
		try{
			FormatOfTournament = EMF.getEM().createNamedQuery("Formatoftournament.findAll",Formatoftournament.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return FormatOfTournament;
	}
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
	public static List<Registration> findAllRegistrations(){
		List<Registration> registrations = new ArrayList<Registration>();
		try{
			registrations = EMF.getEM().createNamedQuery("Registration.findAll",Registration.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return registrations;
	}

	//Is User registered
	public static long isUserRegistered(int idTournament, int idUser){

		return (long) EMF.getEM().createNamedQuery("Registration.isUserRegistered").setParameter("tournament", idTournament).setParameter("user", idUser).getSingleResult();
	}

	//Get registration by user and tournament
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
