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
	private int idUsers;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String firstname;

	private int idUsersStatus;

	private String name;

	private String phoneNumber;

	private String pseudo;

	//bi-directional many-to-one association to Selection
	@OneToMany(mappedBy="user")
	private List<Selection> selections;

	//bi-directional many-to-many association to Clan
	@ManyToMany
	@JoinTable(
		name="usersclan"
		, joinColumns={
			@JoinColumn(name="idUsers")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idClan")
			}
		)
	private List<Clan> clans;

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

	public int getIdUsersStatus() {
		return this.idUsersStatus;
	}

	public void setIdUsersStatus(int idUsersStatus) {
		this.idUsersStatus = idUsersStatus;
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

	public List<Clan> getClans() {
		return this.clans;
	}

	public void setClans(List<Clan> clans) {
		this.clans = clans;
	}

}