package mt.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestLucas
 */
@WebServlet("/TestLucas")
public class TestLucas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLucas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String nameUser = "lucas-Giunta";
				if(nameUser.matches("^[a-zA-Z_-]{3,20}$")){
					System.out.println("Name: OK");
				}else{
					System.out.println("Name: Error");
				}
				
				String firstnameUser = "Lucas";
				if(firstnameUser.matches("^[a-zA-Z_-]{3,20}$")){
					System.out.println("firstname: OK");
				}else{
					System.out.println("firstname: Error");
				}
				
				String mailUser = "Lucas.giunta@outlook.uk.com";
				if(mailUser.matches("^[^-_()!{}$&µ£=:+;,/\\.][a-zA-Z-.]+@[a-zA-Z-.]+\\.[a-zA-Z]{1,100}$")){
					System.out.println("mail: OK");
				}else{
					System.out.println("mail: Error");
				}
				
				String pseudoUser = "lo1";
				if(pseudoUser.matches("^[a-z0-9]{4,20}$")){
					System.out.println("pseudo: OK");
				}else{
					System.out.println("pseudo: Error");
				}
				
				String phoneUser = "0497/123-123";
				if(phoneUser.matches("^\\d{4}/\\d{3}-\\d{3}$")){
					System.out.println("phone: OK");
				}else{
					System.out.println("phone: Error");
				}
				
				String passUser = "lolM1";
				if(passUser.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([A-Za-z0-9]){3,20}$")){
					System.out.println("pass: OK");
				}else{
					System.out.println("pass: Error");
				}
				
				
		
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
