package mt.servlets;

import java.io.IOException;
import java.util.Date;

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
import mt.entities.Formatoftournament;
import mt.entities.Platform;
import mt.entities.Typeoftournament;
import mt.entities.User;
import mt.util.NmdQueries;
import mt.util.Util;
import mt.validation.FormatoftournamentCreation;
import mt.validation.PlatformCreation;
import mt.validation.TypeoftournamentCreation;
import mt.validation.Validation;

/**
 * Servlet implementation class SrvAdminDashboard
 */
@WebServlet("/dashboard")
public class SrvAdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SrvAdminDashboard.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvAdminDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User loggedUser = Util.getLoggedUser(request);
		String errMsg = null;
		
		if(loggedUser != null){
			if(loggedUser.getIdUsers() == 1){
				ServletContext context = request.getSession().getServletContext();
				
				request.setAttribute("listPlatforms", NmdQueries.findAllPlatforms());//context.getAttribute("platforms"));
				request.setAttribute("listGames", context.getAttribute("games"));
				request.setAttribute("listFormatOfTournament", NmdQueries.findAllFormatOfTournament());//context.getAttribute("formatOfTournament"));
				request.setAttribute("listTypeOfTournament", NmdQueries.findAllTypeOfTournament());//context.getAttribute("typeOfTournament"));				
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/admin/dashboard.jsp").forward(request, response);
			}else{
				
				errMsg = "This url is not found ! ";
				request.setAttribute("errMsg", errMsg);
				response.sendRedirect("error");
			}
		}else{
			
			errMsg = "This url is not found ! ";
			request.setAttribute("errMsg", errMsg);
			response.sendRedirect("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EMF.getEMF();
		EntityManager em = EMF.getEM();
		
		String btnPlatforms = request.getParameter("btnPlatforms");
		String btnRemovePlatforms = request.getParameter("btnRemovePlatforms");
		String btnActivePlatforms = request.getParameter("btnActivePlatforms");
		
		String btnTypeoftournament = request.getParameter("btnTypeoftournament");
		String btnRemoveTypeoftournament = request.getParameter("btnRemoveTypeoftournament");
		String btnActiveTypeoftournament = request.getParameter("btnActiveTypeoftournament");
		
		String btnFormatoftournament = request.getParameter("btnFormatoftournament");
		String btnRemoveFormatoftournament = request.getParameter("btnRemoveFormatoftournament");
		String btnActiveFormatoftournament = request.getParameter("btnActiveFormatoftournament");
		
		String errMsg = null;
		String successMsg = null;
		
		//CREATE PLATFORMS
		if(btnPlatforms != null){
			Platform platform = new Platform();
			Validation<Platform> v = new Validation<Platform>();
			if(v.validate(request, platform)){
				PlatformCreation.create(request, platform);
				if(platform != null){
					try{
						em.getTransaction().begin();
						em.persist(platform);
						em.getTransaction().commit();
						successMsg = "Platform created successfully ! ";
						request.setAttribute("successMsg", successMsg);
						doGet(request, response);
						logger.log(Level.INFO, platform.getName()+" created successfully ! ");
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
				}
			}
		}
		//REMOVE PLATFORMS
		if(btnRemovePlatforms != null){
			Platform platform = NmdQueries.findPlatformById(Integer.parseInt(request.getParameter("idPlatforms")));
			if(platform != null){
				try{
					em.getTransaction().begin();
					platform.setActive(false);
					em.merge(platform);
					em.getTransaction().commit();
					successMsg = platform.getName()+" removed successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, platform.getName()+" removed successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This platform is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "Platform is not found");
			}
		}
		//RE ACTIVE PLATFORMS
		if(btnActivePlatforms != null){
			Platform platform = NmdQueries.findPlatformById(Integer.parseInt(request.getParameter("idPlatforms")));
			if(platform != null){
				try{
					em.getTransaction().begin();
					platform.setActive(true);
					em.merge(platform);
					em.getTransaction().commit();
					successMsg = platform.getName()+" re actived successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, platform.getName()+" re actived successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This platform is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "Platform is not found");
			}
		}
		//CREATE TYPE OF TOURNAMENT
		if(btnTypeoftournament != null){
			Typeoftournament type = new Typeoftournament();
			Validation<Typeoftournament> v = new Validation<Typeoftournament>();
			if(v.validate(request, type)){
				TypeoftournamentCreation.create(request, type);
				if(type != null){
					try{
						em.getTransaction().begin();
						em.persist(type);
						em.getTransaction().commit();
						successMsg = type.getName()+" created successfully ! ";
						request.setAttribute("successMsg", successMsg);
						logger.log(Level.INFO, type.getName()+" created successfully ! ");
						doGet(request, response);
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
				}
			}
		}
		//DELETE TYPE OF TOURNAMENT
		if(btnRemoveTypeoftournament != null){
			Typeoftournament type = NmdQueries.findTypeOfTournamentById(Integer.parseInt(request.getParameter("idTypeoftournament")));
			if(type != null){
				try{
					em.getTransaction().begin();
					type.setActive(false);
					em.merge(type);
					em.getTransaction().commit();
					successMsg = type.getName()+" removed successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, type.getName()+" removed successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This type of tournament is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "This type of tournament is not found");
			}
		}
		//RE ACTIVE TYPE OF TOURNAMENT
		if(btnActiveTypeoftournament != null){
			Typeoftournament type = NmdQueries.findTypeOfTournamentById(Integer.parseInt(request.getParameter("idTypeoftournament")));
			if(type != null){
				try{
					em.getTransaction().begin();
					type.setActive(true);
					em.merge(type);
					em.getTransaction().commit();
					successMsg = type.getName()+" re actived successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, type.getName()+" re actived successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This type of tournament is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "This type of tournament is not found");
			}
		}
		//CREATE FORMAT OF TOURNAMENT
		if(btnFormatoftournament != null){
			Formatoftournament format = new Formatoftournament();
			Validation<Formatoftournament> v = new Validation<Formatoftournament>();
			if(v.validate(request, format)){
				FormatoftournamentCreation.create(request, format);
				if(format != null){
					try{
						em.getTransaction().begin();
						em.persist(format);
						em.getTransaction().commit();
						successMsg = format.getName()+" created successfully ! ";
						request.setAttribute("successMsg", successMsg);
						logger.log(Level.INFO, format.getName()+" created successfully ! ");
						doGet(request, response);
					}catch(Exception e){
						logger.log(Level.INFO, e.getMessage());
					}finally {
						em.close();
					}
				}
			}
		}
		//REMOVE FORMAT OF TOURNAMENT
		if(btnRemoveFormatoftournament != null){
			Formatoftournament format = NmdQueries.findFormatoftournamentById(Integer.parseInt(request.getParameter("idFormatoftournament")));
			if(format != null){
				try{
					em.getTransaction().begin();
					format.setActive(false);
					em.merge(format);
					em.getTransaction().commit();
					successMsg = format.getName()+" removed successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, format.getName()+" removed successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This format of tournament is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "This format of tournament is not found");
			}
		}
		//RE ACTIVE FORMAT OF TOURNAMENT
		if(btnActiveFormatoftournament != null){
			Formatoftournament format = NmdQueries.findFormatoftournamentById(Integer.parseInt(request.getParameter("idFormatoftournament")));
			if(format != null){
				try{
					em.getTransaction().begin();
					format.setActive(true);
					em.merge(format);
					em.getTransaction().commit();
					successMsg = format.getName()+" re actived successfully ! ";
					request.setAttribute("successMsg", successMsg);
					logger.log(Level.INFO, format.getName()+" re actived successfully ! ");
					doGet(request, response);
				}catch(Exception e){
					logger.log(Level.INFO, e.getMessage());
				}finally {
					em.close();
				}
			}else{
				errMsg = "This format of tournament is not found !";
				request.setAttribute("errMsg", errMsg);
				doGet(request, response);
				logger.log(Level.INFO, "This format of tournament is not found");
			}
		}
	}

}
