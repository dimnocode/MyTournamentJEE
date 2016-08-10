package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the platforms database table.
 * 
 */
@Entity
@Table(name="platforms")
@NamedQueries({
	@NamedQuery (name="Platform.findAll", query="SELECT p FROM Platform p"),
	@NamedQuery (name="Platform.find", query="SELECT p FROM Platform p WHERE p.idPlatforms = :idPlatforms")
})
public class Platform implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPlatforms;

	private boolean active;

	private String name;

	//bi-directional many-to-one association to Gameaccount
	@OneToMany(mappedBy="platform")
	private List<Gameaccount> gameaccounts;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="platform")
	private List<Game> games;

	public Platform() {
	}

	public int getIdPlatforms() {
		return this.idPlatforms;
	}

	public void setIdPlatforms(int idPlatforms) {
		this.idPlatforms = idPlatforms;
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

	public List<Gameaccount> getGameaccounts() {
		return this.gameaccounts;
	}

	public void setGameaccounts(List<Gameaccount> gameaccounts) {
		this.gameaccounts = gameaccounts;
	}

	public Gameaccount addGameaccount(Gameaccount gameaccount) {
		getGameaccounts().add(gameaccount);
		gameaccount.setPlatform(this);

		return gameaccount;
	}

	public Gameaccount removeGameaccount(Gameaccount gameaccount) {
		getGameaccounts().remove(gameaccount);
		gameaccount.setPlatform(null);

		return gameaccount;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setPlatform(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setPlatform(null);

		return game;
	}

}