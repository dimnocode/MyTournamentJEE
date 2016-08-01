package mt.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import mt.connection.EMF;
import mt.entities.Gameaccount;
import mt.entities.Gameaccountplatform;
import mt.entities.User;

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
		HttpSession session = request.getSession();
		
		User user = new User();
		user = (User)session.getAttribute("loggedUser");
		
		session.getAttribute("loggedUser");
		request.setAttribute("listGameAccount", find(user.getIdUsers()));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private List<Gameaccount> find(int idUsers){
		List<Gameaccount> gameAccounts = null;
		try{
			gameAccounts = EMF.getEM().createNamedQuery("Gameaccount.findByUser").setParameter("idUsers", idUsers).getResultList();
		}catch(NoResultException e){
			return null;
		}
		return gameAccounts;
	}

}
