package mt.repository;

import java.util.List;

import javax.persistence.EntityManager;

import mt.connection.EMF;

import mt.entities.Userrole;

public class UsersstatutRepository implements IRepository<Userrole>{

	private EntityManager em;
	
	public UsersstatutRepository(){
		this.em = EMF.getEM();
	}
	
	public Userrole update(Userrole user){
		return this.em.merge(user);
	}
	public void delete(int id){
		Userrole user = find(id);
		this.em.remove(user);
	}
	public void create(Userrole user){
		this.em.persist(user);
	}
	public Userrole find(int id){
		return this.em.find(Userrole.class, id); 
	}
	public List<Userrole> findAll(){
		return this.em.createNamedQuery("Userrole.findAll").getResultList(); 
	}
	public void close(){
		this.em.close();
	}
}
