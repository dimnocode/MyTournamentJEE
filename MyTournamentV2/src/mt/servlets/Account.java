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
import mt.validation.Validation;

/**
 * Servlet implementation class Account
 */
@WebServlet("/account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Account.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
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
			doGet(request, response);
		}
		else{
			response.sendRedirect("error");
		}
	}
	
	
	
}
