package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeoftournaments database table.
 * 
 */
@Entity
@Table(name="typeoftournaments")
@NamedQuery(name="Typeoftournament.findAll", query="SELECT t FROM Typeoftournament t")
public class Typeoftournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTypeOfTournaments;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="typeoftournament")
	private List<Tournament> tournaments;

	public Typeoftournament() {
	}

	public int getIdTypeOfTournaments() {
		return this.idTypeOfTournaments;
	}

	public void setIdTypeOfTournaments(int idTypeOfTournaments) {
		this.idTypeOfTournaments = idTypeOfTournaments;
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

	public List<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Tournament addTournament(Tournament tournament) {
		getTournaments().add(tournament);
		tournament.setTypeoftournament(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setTypeoftournament(null);

		return tournament;
	}

}