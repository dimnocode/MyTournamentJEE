package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the unavailabilities database table.
 * 
 */
@Entity
@Table(name="unavailabilities")
@NamedQuery(name="Unavailability.findAll", query="SELECT u FROM Unavailability u")
public class Unavailability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUnavailabilities;

	private int day;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUsers", nullable=false)
	private User user;

	public Unavailability() {
	}

	public int getIdUnavailabilities() {
		return this.idUnavailabilities;
	}

	public void setIdUnavailabilities(int idUnavailabilities) {
		this.idUnavailabilities = idUnavailabilities;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}