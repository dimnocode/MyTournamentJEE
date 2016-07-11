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
@NamedQuery(name="Gameaccount.findAll", query="SELECT g FROM Gameaccount g")
public class Gameaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGameAccounts;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Gameaccountplatform
	@ManyToOne
	@JoinColumn(name="idGameAccountPlatforms", nullable=false)
	private Gameaccountplatform gameaccountplatform;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers", nullable=false)
	private User user;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="gameaccount")
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

	public Gameaccountplatform getGameaccountplatform() {
		return this.gameaccountplatform;
	}

	public void setGameaccountplatform(Gameaccountplatform gameaccountplatform) {
		this.gameaccountplatform = gameaccountplatform;
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

	public Game addGame(Game game) {
		getGames().add(game);
		game.setGameaccount(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setGameaccount(null);

		return game;
	}

}