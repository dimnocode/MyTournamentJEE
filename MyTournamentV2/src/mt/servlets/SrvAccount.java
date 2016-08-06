package mt.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.User;
import mt.util.NmdQueries;
import mt.util.Util;
import mt.validation.GameAccountCreation;
import mt.validation.UserCreation;
import mt.validation.Validation;

/**
 * Servlet implementation class Account
 */
@WebServlet("/account")
public class SrvAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvAccount.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User user = Util.getLoggedUser(request);
		
		if(user != null){
			//session.getAttribute("loggedUser");
			
			ServletContext context = request.getSession().getServletContext();	
			
			//request.setAttribute("flagUpdate", false);
			request.setAttribute("listGameAccount", NmdQueries.findGameAccounts(user.getIdUsers()));
			request.setAttribute("listPlatforms", context.getAttribute("platforms") );//NmdQueries.findAllPlatforms()
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		String btnGameAccount = request.getParameter("btnGameAccount");
		String btnEditUser = request.getParameter("btnEditUser");
		String btnChangeUser = request.getParameter("btnChangeUser");
		String btnEditPasswordUser = request.getParameter("btnEditPasswordUser");
		String successMsg = null;
		//CREATION D UN GAMEACCOUNT
		if(btnGameAccount != null){
			if(Util.getLoggedUser(request) != null){
				Gameaccount gameAccount = new Gameaccount();
				Validation<Gameaccount> v = new Validation<Gameaccount>();

				if(v.validate(request, gameAccount)){
					GameAccountCreation.create(request, gameAccount);
					if(gameAccount != null){
						logger.log(Level.INFO, "GameAccount created :" + gameAccount.getName());
						em.getTransaction().begin();
						em.persist(gameAccount);
						em.getTransaction().commit();
					}
				}else{
					response.sendRedirect("account");
					logger.log(Level.INFO, "GameAccount not valid");
				}
				em.close();
			}
			else{
				response.sendRedirect("error");
			}
		}
		//BOUTON POUR AFFICHER LES FORMULAIRE DE MODIFICATION
		if(btnEditUser != null){
			request.setAttribute("flagUpdate", true);
		}
		//FORMULAIRE UPDATE LE PASSWORD USER
		//N EST PAS FONCTIONNELLE, VOIR LE FICHIER USERVALIDATION 
		if(btnEditPasswordUser != null){
			successMsg = "Your password be changed";
			
			User user = Util.getLoggedUser(request);
			Validation<User> v = new Validation<User>();
			
			if(v.validate(request, user)){
				UserCreation.updatePassword(request, user);
				if(user != null){
					logger.log(Level.INFO, "User password update :" + user.getPassword());
					em.getTransaction().begin();
					em.merge(user);
					em.getTransaction().commit();
					em.close();
					
					request.setAttribute("successMsg", successMsg);
					request.setAttribute("flagUpdate", false);
				}
			}
			
			request.setAttribute("successMsg", successMsg);
			request.setAttribute("flagUpdate", false);
		}
		//FORMULAIRE UPDATE LES INFORMATIONS USER
		if(btnChangeUser != null){
			successMsg = "Your information be changed";
			
			User user = Util.getLoggedUser(request);
			Validation<User> v = new Validation<User>();
		
			if(v.validate(request, user)){
				UserCreation.updateInfo(request, user);
				if(user != null){
					logger.log(Level.INFO, "User update :" + user.getName() + " " + user.getFirstname() + " " + user.getPseudo() + "" + user.getPhoneNumber());
					em.getTransaction().begin();
					em.merge(user);
					em.getTransaction().commit();
					em.close();
					
					request.setAttribute("successMsg", successMsg);
					request.setAttribute("flagUpdate", false);
				}
			}
		}
		doGet(request, response);
	}
	
	
	
}
