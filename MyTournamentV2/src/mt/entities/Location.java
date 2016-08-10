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
	private int idLocations;

	private String country;

	private String street;

	private String town;

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