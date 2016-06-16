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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idSelections;

	@Column(nullable=false)
	private Object confirmation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date creationDate;

	@Column(nullable=false)
	private Object validation;

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

	public Selection() {
	}

	public int getIdSelections() {
		return this.idSelections;
	}

	public void setIdSelections(int idSelections) {
		this.idSelections = idSelections;
	}

	public Object getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(Object confirmation) {
		this.confirmation = confirmation;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Object getValidation() {
		return this.validation;
	}

	public void setValidation(Object validation) {
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