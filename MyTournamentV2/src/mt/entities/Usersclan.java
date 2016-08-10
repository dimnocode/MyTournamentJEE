package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usersclans database table.
 * 
 */
@Entity
@Table(name="usersclans")
@NamedQuery(name="Usersclan.findAll", query="SELECT u FROM Usersclan u")
public class Usersclan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUsersClans;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date addedDateTime;

	private boolean clanLeader;

	@Temporal(TemporalType.TIMESTAMP)
	private Date removedDateTime;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="idClan", nullable=false)
	private Clan clan;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers", nullable=false)
	private User user;

	public Usersclan() {
	}

	public int getIdUsersClans() {
		return this.idUsersClans;
	}

	public void setIdUsersClans(int idUsersClans) {
		this.idUsersClans = idUsersClans;
	}

	public Date getAddedDateTime() {
		return this.addedDateTime;
	}

	public void setAddedDateTime(Date addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

	public boolean getClanLeader() {
		return this.clanLeader;
	}

	public void setClanLeader(boolean clanLeader) {
		this.clanLeader = clanLeader;
	}

	public Date getRemovedDateTime() {
		return this.removedDateTime;
	}

	public void setRemovedDateTime(Date removedDateTime) {
		this.removedDateTime = removedDateTime;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}