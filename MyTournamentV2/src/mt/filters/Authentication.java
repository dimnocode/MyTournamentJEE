package mt.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mt.entities.User;
import mt.util.Util;

/**
 * Servlet Filter implementation class authentication
 */
@WebFilter(filterName = "Authentication", urlPatterns = {"/account", "/game", "/tournament", "/clans"})
public class Authentication implements Filter {

	private static final Logger logger = Logger.getLogger(Authentication.class);

	/**
	 * Default constructor. 
	 */
	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		User user = Util.getLoggedUser(req);
		
		if(user == null){
//			HttpServletResponse resp = (HttpServletResponse) response;
			logger.log(Level.INFO, "User is not logged : " + req.getServletPath());
			
			req.setAttribute("errMsg", "You are not logged in");
//			resp.sendRedirect("error?errMsg=NotLoggedIn");
			
			req.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			
		}else{
			req.getServletContext().getContextPath();
			logger.log(Level.INFO, "User is logged: " + req.getServletPath());
			chain.doFilter(request, response);			
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
