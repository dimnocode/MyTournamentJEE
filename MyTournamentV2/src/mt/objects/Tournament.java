package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tournaments database table.
 * 
 */
@Entity
@Table(name="tournaments")
@NamedQuery(name="Tournament.findAll", query="SELECT t FROM Tournament t")
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTournaments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date endDate;

	@Column(nullable=false)
	private Time hours;

	@Column(nullable=false)
	private int maxPlayers;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false)
	private boolean online;

	private float price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to Reward
	@OneToMany(mappedBy="tournament")
	private List<Reward> rewards;

	//bi-directional many-to-one association to Selection
	@OneToMany(mappedBy="tournament")
	private List<Selection> selections;

	//bi-directional many-to-one association to Formattournament
	@ManyToOne
	@JoinColumn(name="idFormatTournaments", nullable=false)
	private Formattournament formattournament;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="idGames", nullable=false)
	private Game game;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="idLocations")
	private Location location;

	//bi-directional many-to-many association to Sponsor
	@ManyToMany
	@JoinTable(
		name="tournamentsponsor"
		, joinColumns={
			@JoinColumn(name="idTournaments", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idSponsors", nullable=false)
			}
		)
	private List<Sponsor> sponsors;

	//bi-directional many-to-one association to Typeoftournament
	@ManyToOne
	@JoinColumn(name="idTypeOfTournaments", nullable=false)
	private Typeoftournament typeoftournament;

	public Tournament() {
	}

	public int getIdTournaments() {
		return this.idTournaments;
	}

	public void setIdTournaments(int idTournaments) {
		this.idTournaments = idTournaments;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getHours() {
		return this.hours;
	}

	public void setHours(Time hours) {
		this.hours = hours;
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Date getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Reward> getRewards() {
		return this.rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public Reward addReward(Reward reward) {
		getRewards().add(reward);
		reward.setTournament(this);

		return reward;
	}

	public Reward removeReward(Reward reward) {
		getRewards().remove(reward);
		reward.setTournament(null);

		return reward;
	}

	public List<Selection> getSelections() {
		return this.selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public Selection addSelection(Selection selection) {
		getSelections().add(selection);
		selection.setTournament(this);

		return selection;
	}

	public Selection removeSelection(Selection selection) {
		getSelections().remove(selection);
		selection.setTournament(null);

		return selection;
	}

	public Formattournament getFormattournament() {
		return this.formattournament;
	}

	public void setFormattournament(Formattournament formattournament) {
		this.formattournament = formattournament;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Typeoftournament getTypeoftournament() {
		return this.typeoftournament;
	}

	public void setTypeoftournament(Typeoftournament typeoftournament) {
		this.typeoftournament = typeoftournament;
	}

}