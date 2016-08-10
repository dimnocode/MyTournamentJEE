package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clans database table.
 * 
 */
@Entity
@Table(name="clans")
@NamedQueries({

	@NamedQuery(name="Clan.findAll", query="SELECT c FROM Clan c"),
	@NamedQuery(name="Clan.findById", query="SELECT c FROM Clan c WHERE c.idClan = :idClans")
})
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idClan;

	private boolean active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	private String nom;

	//bi-directional many-to-one association to Webref
	@ManyToOne
	@JoinColumn(name="idWebRef")
	private Webref webref;

	//bi-directional many-to-one association to Registration
	@OneToMany(mappedBy="clan")
	private List<Registration> registrations;

	//bi-directional many-to-one association to Usersclan
	@OneToMany(mappedBy="clan")
	private List<Usersclan> usersclans;

	public Clan() {
	}

	public int getIdClan() {
		return this.idClan;
	}

	public void setIdClan(int idClan) {
		this.idClan = idClan;
	}

	public boolean isActive() {
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

	public List<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addRegistration(Registration registration) {
		getRegistrations().add(registration);
		registration.setClan(this);

		return registration;
	}

	public Registration removeRegistration(Registration registration) {
		getRegistrations().remove(registration);
		registration.setClan(null);

		return registration;
	}

	public List<Usersclan> getUsersclans() {
		return this.usersclans;
	}

	public void setUsersclans(List<Usersclan> usersclans) {
		this.usersclans = usersclans;
	}

	public Usersclan addUsersclan(Usersclan usersclan) {
		getUsersclans().add(usersclan);
		usersclan.setClan(this);

		return usersclan;
	}

	public Usersclan removeUsersclan(Usersclan usersclan) {
		getUsersclans().remove(usersclan);
		usersclan.setClan(null);

		return usersclan;
	}

}