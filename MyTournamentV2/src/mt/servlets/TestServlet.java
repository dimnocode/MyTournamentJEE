package mt.servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.entities.User;
import mt.entities.Userrole;
import mt.repository.UsersstatutRepository;
/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(TestServlet.class);
	
    //@PersistenceUnit(unitName="MyTournamentV2")
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyTournamentV2");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EntityManager em;
		em = emf.createEntityManager();
		
		//User u = new User();
		
		UsersstatutRepository us = new UsersstatutRepository();
//		
//		Userrole uss = us.find(1);
//		uss.setName("User");
//		//us.update(uss);
//		em.getTransaction().begin();
//		em.merge(uss);
//		em.getTransaction().commit();
		
		
		User u = new User();
		u.setName("test");
		u.setFirstname("test");
		u.setPseudo("t");
		u.setPassword("pswd");
		u.setCreationDate(new Date());
		u.setDob(new Date());
		u.setEmail("lol@lol.com");
		u.setPhoneNumber("000");
		u.setUserrole(us.find(1));
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
		logger.log(Level.INFO, u.getName()+ " saved");
		
		em.close();
		emf.close();
		/*
		
		Game g = new Game();
		
		
		g.setName("Overwatch");
		try{
			em.getTransaction().begin();
			em.persist(g);
			em.getTransaction().commit();
			System.out.println("OK");
		}catch(PersistenceException pe){
			System.out.println("Erreur");
		}finally{
			em.close();
			emf.close();
		}
		*/
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
