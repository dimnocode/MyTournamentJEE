package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usersstatuts database table.
 * 
 */
@Entity
@Table(name="usersstatuts")
@NamedQuery(name="Usersstatut.findAll", query="SELECT u FROM Usersstatut u")
public class Usersstatut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUsersStatus;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="usersstatut")
	private List<User> users;

	public Usersstatut() {
	}

	public int getIdUsersStatus() {
		return this.idUsersStatus;
	}

	public void setIdUsersStatus(int idUsersStatus) {
		this.idUsersStatus = idUsersStatus;
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
		user.setUsersstatut(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUsersstatut(null);

		return user;
	}

}