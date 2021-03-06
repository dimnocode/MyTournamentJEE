package mt.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.validation.UserCreation;
import mt.validation.Validation;
import mt.entities.User;
import mt.util.NmdQueries;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class SrvRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvRegister.class);
   
    public SrvRegister() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		String errMsg = null;
		
		User user = new User();
		Validation<User> v = new Validation<User>();
		
		if(v.validate(request, user)){
			UserCreation.create(request, user);
			if(user != null){
				if(NmdQueries.findUserByEmailOrPseudo(user.getEmail(), user.getPseudo()) == null){
					try{
						logger.log(Level.INFO, "User created :" + user.getName() + " " + user.getFirstname() + " " + user.getPassword());
						em.getTransaction().begin();
						em.persist(user);
						em.getTransaction().commit();
						response.sendRedirect("login");
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
				}else{
					logger.log(Level.INFO, user.getEmail() + " " + user.getPseudo() + ". Impossible to register");
					errMsg = "This pseudo or email exist. Impossible to register";
					request.setAttribute("errMsg", errMsg);
					doGet(request, response);
				}
			}
		}else{
			doGet(request, response);
		}	
		
	}

}
