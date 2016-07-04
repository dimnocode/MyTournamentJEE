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
		this.validation = new Validation(http, new User());
	}
	
	public User update(User user){
		return this.em.merge(user);
	}
	public void delete(int id){
		User user = find(id);
		this.em.remove(user);
	}
	public void create(User user){
		this.em.persist(user);
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
}
