package mt.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import mt.connection.EMF;
import mt.objects.User;
import mt.objects.Usersstatut;

public class UsersstatutRepository implements IRepository<Usersstatut>{

	private EntityManager em;
	
	public UsersstatutRepository(){
		this.em = EMF.getEM();
	}
	
	public Usersstatut update(Usersstatut user){
		return this.em.merge(user);
	}
	public void delete(int id){
		Usersstatut user = find(id);
		this.em.remove(user);
	}
	public void create(Usersstatut user){
		this.em.persist(user);
	}
	public Usersstatut find(int id){
		return this.em.find(Usersstatut.class, id); 
	}
	public List<Usersstatut> findAll(){
		return this.em.createNamedQuery("Usersstatut.findAll").getResultList(); 
	}
	public void close(){
		this.em.close();
	}
}
