package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the webref database table.
 * 
 */
@Entity
@Table(name="webref")
@NamedQuery(name="Webref.findAll", query="SELECT w FROM Webref w")
public class Webref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idWebRef;

	@Column(length=100)
	private String locationWeb;

	@Column(length=100)
	private String logo;

	//bi-directional many-to-one association to Clan
	@OneToMany(mappedBy="webref")
	private List<Clan> clans;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="webref")
	private List<Game> games;

	//bi-directional many-to-one association to Sponsor
	@OneToMany(mappedBy="webref")
	private List<Sponsor> sponsors;

	public Webref() {
	}

	public int getIdWebRef() {
		return this.idWebRef;
	}

	public void setIdWebRef(int idWebRef) {
		this.idWebRef = idWebRef;
	}

	public String getLocationWeb() {
		return this.locationWeb;
	}

	public void setLocationWeb(String locationWeb) {
		this.locationWeb = locationWeb;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

	public Clan addClan(Clan clan) {
		getClans().add(clan);
		clan.setWebref(this);

		return clan;
	}

	public Clan removeClan(Clan clan) {
		getClans().remove(clan);
		clan.setWebref(null);

		return clan;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setWebref(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setWebref(null);

		return game;
	}

	public List<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Sponsor addSponsor(Sponsor sponsor) {
		getSponsors().add(sponsor);
		sponsor.setWebref(this);

		return sponsor;
	}

	public Sponsor removeSponsor(Sponsor sponsor) {
		getSponsors().remove(sponsor);
		sponsor.setWebref(null);

		return sponsor;
	}

}