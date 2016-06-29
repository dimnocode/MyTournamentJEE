package mt.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mt.objects.User;
import mt.repository.IRepository;
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
		String name = request.getParameter("nameRegister") ;
		String firstname = request.getParameter("firstnameRegister") ;
		String email = request.getParameter("emailRegister") ;
		String pseudo = request.getParameter("pseudoRegister") ;
		String password = request.getParameter("passRegister") ;
		String dob = request.getParameter("dobRegister") ;
		Date creation = new Date();
		
		
		System.out.println(name);
		System.out.println(firstname);
		System.out.println(email);
		System.out.println(pseudo);
		System.out.println(password);
		System.out.println(creation);
		
		
		
		//User user = userRepository.create();
		
		/*
		EntityManager em;
		em = emf.createEntityManager();
		User u = new User();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dob);
			System.out.println(formatter.format(date));
			
			u.setName(name);
			u.setFirstname(firstname);
			u.setEmail(email);
			u.setPseudo(pseudo);
			u.setDob(date);
			u.setCreationDate(creation);
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			em.close();
			emf.close();
		}*/
		
		
		
		
		
		
		doGet(request, response);
	}

}
