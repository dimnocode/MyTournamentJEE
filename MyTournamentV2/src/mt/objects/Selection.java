package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the selections database table.
 * 
 */
@Entity
@Table(name="selections")
@NamedQuery(name="Selection.findAll", query="SELECT s FROM Selection s")
public class Selection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSelections;

	private byte confirmation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	private byte validation;

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

	public Selection() {
	}

	public int getIdSelections() {
		return this.idSelections;
	}

	public void setIdSelections(int idSelections) {
		this.idSelections = idSelections;
	}

	public byte getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(byte confirmation) {
		this.confirmation = confirmation;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public byte getValidation() {
		return this.validation;
	}

	public void setValidation(byte validation) {
		this.validation = validation;
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