package mt.servlets;


import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.User;
import mt.util.Hashing;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String errMsg = null;
		
		String btnLogin = request.getParameter("btnLogin");
		//request.getParameterNames()
		
		
		if(btnLogin != null){
			User loggedUser = userLogin(request.getParameter("emailLogin"), Hashing.hash(request.getParameter("passLogin")));
			
			if(loggedUser != null){
				logger.log(Level.INFO, "User logged :" + loggedUser.getName() + " " + loggedUser.getFirstname() + " " + loggedUser.getPassword());
				session.setAttribute("loggedUser", loggedUser);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			} else{
				logger.log(Level.INFO, "Incorrect email and/or password");
				errMsg = "Incorrect email and/or password";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
			}
		}	
	}
	
	private User userLogin(String email, String pass){
		User user = new User();
		try{
			user = (User)EMF.getEM().createNamedQuery("User.login").setParameter("email", email).setParameter("pass", pass).getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		return user;
	}

}
