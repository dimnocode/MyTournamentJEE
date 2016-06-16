package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formattournaments database table.
 * 
 */
@Entity
@Table(name="formattournaments")
@NamedQuery(name="Formattournament.findAll", query="SELECT f FROM Formattournament f")
public class Formattournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idFormatTournaments;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="formattournament")
	private List<Tournament> tournaments;

	public Formattournament() {
	}

	public int getIdFormatTournaments() {
		return this.idFormatTournaments;
	}

	public void setIdFormatTournaments(int idFormatTournaments) {
		this.idFormatTournaments = idFormatTournaments;
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
		tournament.setFormattournament(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setFormattournament(null);

		return tournament;
	}

}