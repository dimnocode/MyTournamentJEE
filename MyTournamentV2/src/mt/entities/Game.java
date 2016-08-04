package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the games database table.
 * 
 */
@Entity
@Table(name="games")
@NamedQueries({
	@NamedQuery (name="Game.findAll", query="SELECT g FROM Game g"),
	@NamedQuery (name="Game.findById", query="SELECT g FROM Game g WHERE g.idGames = :idGames"),
	@NamedQuery (name="Game.findByPlatform", query="SELECT g FROM Game g WHERE g.platform.idPlatforms = :idPlatforms AND g.idGames NOT IN ("
			+ "SELECT g.idGames FROM g.gameaccounts AS ga WHERE ga.idGameAccounts = :idGameAccounts)ORDER BY g.name ASC")
})
/*
 * select g.idGames, g.name from games as g
	WHERE g.idPlatforms = 2
	AND g.idGames NOT IN(
    select ga.idGames from gameaccountsgames as ga
    WHERE ga.idGameAccounts = 1
    )
 * */
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGames;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-many association to Gameaccount
	@ManyToMany
	@JoinTable(
		name="gameaccountsgames"
		, joinColumns={
			@JoinColumn(name="idGames", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idGameAccounts", nullable=false)
			}
		)
	private List<Gameaccount> gameaccounts;

	//bi-directional many-to-one association to Webref
	@ManyToOne
	@JoinColumn(name="idWebRef")
	private Webref webref;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="game")
	private List<Tournament> tournaments;

	//bi-directional many-to-one association to Platform
	@ManyToOne
	@JoinColumn(name="idPlatforms", nullable=false)
	private Platform platform;

	public Game() {
	}

	public int getIdGames() {
		return this.idGames;
	}

	public void setIdGames(int idGames) {
		this.idGames = idGames;
	}

	public boolean getActive() {
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

	public Webref getWebref() {
		return this.webref;
	}

	public void setWebref(Webref webref) {
		this.webref = webref;
	}

	public List<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Tournament addTournament(Tournament tournament) {
		getTournaments().add(tournament);
		tournament.setGame(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setGame(null);

		return tournament;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}