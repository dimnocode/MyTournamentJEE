package mt.entities;

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
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.idUsers = :idUsers"),
	@NamedQuery(name="User.login", query="SELECT u FROM User u WHERE u.email = :email AND u.password = :pass")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUsers;

	private boolean active;

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

	@Column(nullable=false, length=128)
	private String password;

	@Column(nullable=false, length=45)
	private String phoneNumber;

	@Column(nullable=false, length=45)
	private String pseudo;

	//bi-directional many-to-many association to Clan
	@ManyToMany(mappedBy="users")
	private List<Clan> clans;

	//bi-directional many-to-one association to Gameaccount
	@OneToMany(mappedBy="user")
	private List<Gameaccount> gameaccounts;

	//bi-directional many-to-one association to Registration
	@OneToMany(mappedBy="user")
	private List<Registration> registrations;

	//bi-directional many-to-one association to Unavailability
	@OneToMany(mappedBy="user")
	private List<Unavailability> unavailabilities;

	//bi-directional many-to-one association to Userrole
	@ManyToOne
	@JoinColumn(name="idUserRoles", nullable=false)
	private Userrole userrole;

	//bi-directional many-to-one association to Usersclan
	@OneToMany(mappedBy="user")
	private List<Usersclan> usersclans;

	public User() {
	}

	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
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

	public List<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addRegistration(Registration registration) {
		getRegistrations().add(registration);
		registration.setUser(this);

		return registration;
	}

	public Registration removeRegistration(Registration registration) {
		getRegistrations().remove(registration);
		registration.setUser(null);

		return registration;
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

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public List<Usersclan> getUsersclans() {
		return this.usersclans;
	}

	public void setUsersclans(List<Usersclan> usersclans) {
		this.usersclans = usersclans;
	}

	public Usersclan addUsersclan(Usersclan usersclan) {
		getUsersclans().add(usersclan);
		usersclan.setUser(this);

		return usersclan;
	}

	public Usersclan removeUsersclan(Usersclan usersclan) {
		getUsersclans().remove(usersclan);
		usersclan.setUser(null);

		return usersclan;
	}

}