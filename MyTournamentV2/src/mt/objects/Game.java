package mt.objects;

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
	private int idGames;

	private int idWebRef;

	private String name;

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

	public int getIdWebRef() {
		return this.idWebRef;
	}

	public void setIdWebRef(int idWebRef) {
		this.idWebRef = idWebRef;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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