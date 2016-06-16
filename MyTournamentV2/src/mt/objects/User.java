package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUsers;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dob;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=45)
	private String firstname;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false, length=45)
	private String phoneNumber;

	@Column(nullable=false, length=45)
	private String pseudo;

	//bi-directional many-to-one association to Gameaccount
	@OneToMany(mappedBy="user")
	private List<Gameaccount> gameaccounts;

	//bi-directional many-to-one association to Selection
	@OneToMany(mappedBy="user")
	private List<Selection> selections;

	//bi-directional many-to-one association to Unavailability
	@OneToMany(mappedBy="user")
	private List<Unavailability> unavailabilities;

	//bi-directional many-to-many association to Clan
	@ManyToMany
	@JoinTable(
		name="usersclan"
		, joinColumns={
			@JoinColumn(name="idUsers", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idClan", nullable=false)
			}
		)
	private List<Clan> clans;

	//bi-directional many-to-one association to Usersstatut
	@ManyToOne
	@JoinColumn(name="idUsersStatus", nullable=false)
	private Usersstatut usersstatut;

	public User() {
	}

	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Gameaccount> getGameaccounts() {
		return this.gameaccounts;
	}

	public void setGameaccounts(List<Gameaccount> gameaccounts) {
		this.gameaccounts = gameaccounts;
	}

	public Gameaccount addGameaccount(Gameaccount gameaccount) {
		getGameaccounts().add(gameaccount);
		gameaccount.setUser(this);

		return gameaccount;
	}

	public Gameaccount removeGameaccount(Gameaccount gameaccount) {
		getGameaccounts().remove(gameaccount);
		gameaccount.setUser(null);

		return gameaccount;
	}

	public List<Selection> getSelections() {
		return this.selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public Selection addSelection(Selection selection) {
		getSelections().add(selection);
		selection.setUser(this);

		return selection;
	}

	public Selection removeSelection(Selection selection) {
		getSelections().remove(selection);
		selection.setUser(null);

		return selection;
	}

	public List<Unavailability> getUnavailabilities() {
		return this.unavailabilities;
	}

	public void setUnavailabilities(List<Unavailability> unavailabilities) {
		this.unavailabilities = unavailabilities;
	}

	public Unavailability addUnavailability(Unavailability unavailability) {
		getUnavailabilities().add(unavailability);
		unavailability.setUser(this);

		return unavailability;
	}

	public Unavailability removeUnavailability(Unavailability unavailability) {
		getUnavailabilities().remove(unavailability);
		unavailability.setUser(null);

		return unavailability;
	}

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

	public Usersstatut getUsersstatut() {
		return this.usersstatut;
	}

	public void setUsersstatut(Usersstatut usersstatut) {
		this.usersstatut = usersstatut;
	}

}