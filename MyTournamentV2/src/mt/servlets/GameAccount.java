package mt.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.Gameaccountplatform;
import mt.validation.GameAccountCreation;
import mt.validation.Validation;


/**
 * Servlet implementation class GameAccount
 */
@WebServlet("/gameAccount")
public class GameAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GameAccount.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("listGameAccountPlatforms", findAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/gameAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		Gameaccount gameAccount = new Gameaccount();
		Validation<Gameaccount> v = new Validation<Gameaccount>();
		
		if(v.validate(request, gameAccount)){
			GameAccountCreation.create(request, gameAccount);
			if(gameAccount != null){
				logger.log(Level.INFO, "GameAccount created :" + gameAccount.getName());
				em.getTransaction().begin();
				em.persist(gameAccount);
				em.getTransaction().commit();
				doGet(request, response);
				//reprend pas les donnée dans la db this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
			}
		}else{
			doGet(request, response);
		}
	}
	
	private List<Gameaccountplatform> findAll(){
		List<Gameaccountplatform> gaps = null;
		try{
			gaps = EMF.getEM().createNamedQuery("Gameaccountplatform.findAll").getResultList();
		}catch(NoResultException e){
			return null;
		}
		return gaps;
	}
}
