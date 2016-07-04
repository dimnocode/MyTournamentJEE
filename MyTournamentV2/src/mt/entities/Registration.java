package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registrations database table.
 * 
 */
@Entity
@Table(name="registrations")
@NamedQuery(name="Registration.findAll", query="SELECT r FROM Registration r")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idRegistration;

	@Column(nullable=false)
	private Object clanLeaderValidation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date creationDate;

	@Column(nullable=false)
	private Object userConfirmation;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="idClan")
	private Clan clan;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="idTournaments", nullable=false)
	private Tournament tournament;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers", nullable=false)
	private User user;

	public Registration() {
	}

	public int getIdRegistration() {
		return this.idRegistration;
	}

	public void setIdRegistration(int idRegistration) {
		this.idRegistration = idRegistration;
	}

	public Object getClanLeaderValidation() {
		return this.clanLeaderValidation;
	}

	public void setClanLeaderValidation(Object clanLeaderValidation) {
		this.clanLeaderValidation = clanLeaderValidation;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Object getUserConfirmation() {
		return this.userConfirmation;
	}

	public void setUserConfirmation(Object userConfirmation) {
		this.userConfirmation = userConfirmation;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}