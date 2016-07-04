package mt.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import mt.connection.EMF;
import mt.objects.User;

public class UserRepository implements IRepository<User>{
	
	private EntityManager em;
	private HttpServletRequest http;
	private Validation validation;

	public Validation getvalidation() {
		return this.validation;
	}
	
	public UserRepository(HttpServletRequest http){
		this.em = EMF.getEM();
		//this.validation = new Validation(http, new User());
	}
	
	public User update(User user){
		return this.em.merge(user);
	}
	public void delete(int id){
		User user = find(id);
		this.em.remove(user);
	}
	public void create(User user){
		if(this.validation.validate()){
			this.createUser(user);
		}
		else{
			System.out.println("erreur");
		}
	}
	public User find(int id){
		return this.em.find(User.class, id); 
	}
	public List<User> findAll(){
		return this.em.createNamedQuery("User.findAll").getResultList(); 
	}
	public void close(){
		this.em.close();
	}
	
	private void createUser(User user){
		user.setName(this.http.getParameter("nameRegister"));
		user.setFirstname(this.http.getParameter("firstnameRegister"));
		user.setEmail(this.http.getParameter("emailRegister"));
		user.setPseudo(this.http.getParameter("pseudoRegister"));
		user.setPhoneNumber(this.http.getParameter("phoneRegister"));
		String password = this.http.getParameter("passRegister");
		user.setDob(this.validation.stringToDate(this.http.getParameter("dobRegister")));
		user.setCreationDate(this.validation.stringToDate(this.validation.getDateNow()));
		//user.setPassword(password); N EXISTE PAS DANS LA DB ... LOL
		
		System.out.println(user.getName());
		System.out.println(user.getFirstname());
		System.out.println(user.getEmail());
		System.out.println(user.getPhoneNumber());
		System.out.println(user.getPseudo());
		System.out.println(password);
		System.out.println(user.getDob());
		System.out.println(user.getCreationDate());
		
		//this.em.persist(user);
	}
}
