package mt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;

import mt.connection.EMF;
import mt.objects.User;

public class UserRepository implements IRepository<User>{
	
	private EntityManager em;
	private HttpServlet http;
	private Validation validation;

	
	public UserRepository(HttpServlet http){
		this.em = EMF.getEM();
		this.validation = new Validation(http, new User());
	}
	
	public User updateT(User user){
		return this.em.merge(user);
	}
	public void deleteT(int id){
		User user = find(id);
		this.em.remove(user);
	}
	public void createT(User user){
		if(this.validation.validate()){
			this.em.persist(user);
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
}
