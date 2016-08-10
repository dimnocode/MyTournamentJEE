package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idLocations;

	@Column(nullable=false, length=45)
	private String country;

	@Column(nullable=false, length=45)
	private String street;

	@Column(nullable=false, length=45)
	private String town;

	@Column(nullable=false, length=45)
	private String zipCode;

	//bi-directional many-to-one association to Sponsor
	@OneToMany(mappedBy="location")
	private List<Sponsor> sponsors;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="location")
	private List<Tournament> tournaments;

	public Location() {
	}

	public int getIdLocations() {
		return this.idLocations;
	}

	public void setIdLocations(int idLocations) {
		this.idLocations = idLocations;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Sponsor addSponsor(Sponsor sponsor) {
		getSponsors().add(sponsor);
		sponsor.setLocation(this);

		return sponsor;
	}

	public Sponsor removeSponsor(Sponsor sponsor) {
		getSponsors().remove(sponsor);
		sponsor.setLocation(null);

		return sponsor;
	}

	public List<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Tournament addTournament(Tournament tournament) {
		getTournaments().add(tournament);
		tournament.setLocation(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setLocation(null);

		return tournament;
	}

}