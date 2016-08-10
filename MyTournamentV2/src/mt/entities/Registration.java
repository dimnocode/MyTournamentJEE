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
	private int idRegistration;

	private boolean clanLeaderValidation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	private boolean userConfirmation;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="idClan")
	private Clan clan;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="idTournaments")
	private Tournament tournament;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers")
	private User user;

	public Registration() {
	}

	public int getIdRegistration() {
		return this.idRegistration;
	}

	public void setIdRegistration(int idRegistration) {
		this.idRegistration = idRegistration;
	}

	public boolean isClanLeaderValidation() {
		return this.clanLeaderValidation;
	}

	public void setClanLeaderValidation(boolean clanLeaderValidation) {
		this.clanLeaderValidation = clanLeaderValidation;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isUserConfirmation() {
		return this.userConfirmation;
	}

	public void setUserConfirmation(boolean userConfirmation) {
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