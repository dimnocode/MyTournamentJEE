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
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGames;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Gameaccount
	@ManyToOne
	@JoinColumn(name="idGameAccounts", nullable=false)
	private Gameaccount gameaccount;

	//bi-directional many-to-one association to Webref
	@ManyToOne
	@JoinColumn(name="idWebRef")
	private Webref webref;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="game")
	private List<Tournament> tournaments;

	public Game() {
	}

	public int getIdGames() {
		return this.idGames;
	}

	public void setIdGames(int idGames) {
		this.idGames = idGames;
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

	public Gameaccount getGameaccount() {
		return this.gameaccount;
	}

	public void setGameaccount(Gameaccount gameaccount) {
		this.gameaccount = gameaccount;
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

}