package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formatoftournaments database table.
 * 
 */
@Entity
@Table(name="formatoftournaments")
@NamedQuery(name="Formatoftournament.findAll", query="SELECT f FROM Formatoftournament f")
public class Formatoftournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idFormatTournaments;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="formatoftournament")
	private List<Tournament> tournaments;

	public Formatoftournament() {
	}

	public int getIdFormatTournaments() {
		return this.idFormatTournaments;
	}

	public void setIdFormatTournaments(int idFormatTournaments) {
		this.idFormatTournaments = idFormatTournaments;
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
		tournament.setFormatoftournament(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setFormatoftournament(null);

		return tournament;
	}

}