package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sponsors database table.
 * 
 */
@Entity
@Table(name="sponsors")
@NamedQuery(name="Sponsor.findAll", query="SELECT s FROM Sponsor s")
public class Sponsor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSponsors;

	private String email;

	private String nom;

	private String phoneNumber;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="idLocations")
	private Location location;

	//bi-directional many-to-one association to Webref
	@ManyToOne
	@JoinColumn(name="idWebRef")
	private Webref webref;

	//bi-directional many-to-many association to Tournament
	@ManyToMany(mappedBy="sponsors")
	private List<Tournament> tournaments;

	public Sponsor() {
	}

	public int getIdSponsors() {
		return this.idSponsors;
	}

	public void setIdSponsors(int idSponsors) {
		this.idSponsors = idSponsors;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

}