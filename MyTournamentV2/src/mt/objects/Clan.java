package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clan database table.
 * 
 */
@Entity
@Table(name="clan")
@NamedQuery(name="Clan.findAll", query="SELECT c FROM Clan c")
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idClan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date creationDate;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Webref
	@ManyToOne
	@JoinColumn(name="idWebRef")
	private Webref webref;

	//bi-directional many-to-one association to Selection
	@OneToMany(mappedBy="clan")
	private List<Selection> selections;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="clans")
	private List<User> users;

	public Clan() {
	}

	public int getIdClan() {
		return this.idClan;
	}

	public void setIdClan(int idClan) {
		this.idClan = idClan;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Webref getWebref() {
		return this.webref;
	}

	public void setWebref(Webref webref) {
		this.webref = webref;
	}

	public List<Selection> getSelections() {
		return this.selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public Selection addSelection(Selection selection) {
		getSelections().add(selection);
		selection.setClan(this);

		return selection;
	}

	public Selection removeSelection(Selection selection) {
		getSelections().remove(selection);
		selection.setClan(null);

		return selection;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}