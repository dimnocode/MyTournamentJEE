package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gameaccounts database table.
 * 
 */
@Entity
@Table(name="gameaccounts")
@NamedQueries({
	@NamedQuery (name="Gameaccount.findAll", query="SELECT g FROM Gameaccount g"),
	@NamedQuery (name="Gameaccount.findByUser", query="SELECT g FROM Gameaccount g WHERE g.user.idUsers = :idUsers"),
	@NamedQuery (name="Gameaccount.findByIdGameaccount", query="SELECT g FROM Gameaccount g WHERE g.idGameAccounts = :idGameAccounts")
})
public class Gameaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGameAccounts;

	private boolean active;

	private String name;

	//bi-directional many-to-one association to Platform
	@ManyToOne
	@JoinColumn(name="idPlatforms")
	private Platform platform;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers")
	private User user;

	//bi-directional many-to-many association to Game
	@ManyToMany(mappedBy="gameaccounts")
	private List<Game> games;

	public Gameaccount() {
	}

	public int getIdGameAccounts() {
		return this.idGameAccounts;
	}

	public void setIdGameAccounts(int idGameAccounts) {
		this.idGameAccounts = idGameAccounts;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}