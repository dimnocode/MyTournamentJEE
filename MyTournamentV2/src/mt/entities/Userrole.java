package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userroles database table.
 * 
 */
@Entity
@Table(name="userroles")
@NamedQuery(name="Userrole.findAll", query="SELECT u FROM Userrole u")
public class Userrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUserRoles;

	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userrole")
	private List<User> users;

	public Userrole() {
	}

	public int getIdUserRoles() {
		return this.idUserRoles;
	}

	public void setIdUserRoles(int idUserRoles) {
		this.idUserRoles = idUserRoles;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserrole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserrole(null);

		return user;
	}

}