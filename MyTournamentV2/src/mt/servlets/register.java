package mt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mt.connection.EMF;
import mt.objects.User;
import mt.repository.UserRepository;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public register() {
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
		/*String name = request.getParameter("nameRegister") ;
		String firstname = request.getParameter("firstnameRegister") ;
		String email = request.getParameter("emailRegister") ;
		String pseudo = request.getParameter("pseudoRegister") ;
		String password = request.getParameter("passRegister") ;
		String dob = request.getParameter("dobRegister") ;*/

		EMF.getEMF();
		
		User user = new User();
		
		UserRepository userRepository = new UserRepository(request);
		//userRepository.create(user);
		
		//userRepository.close();
		
		doGet(request, response);
	}

}
