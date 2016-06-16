package mt.objects;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rewards database table.
 * 
 */
@Entity
@Table(name="rewards")
@NamedQuery(name="Reward.findAll", query="SELECT r FROM Reward r")
public class Reward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idRewards;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="idTournaments", nullable=false)
	private Tournament tournament;

	//bi-directional many-to-one association to Typeofreward
	@ManyToOne
	@JoinColumn(name="idTypeOfRewards", nullable=false)
	private Typeofreward typeofreward;

	public Reward() {
	}

	public int getIdRewards() {
		return this.idRewards;
	}

	public void setIdRewards(int idRewards) {
		this.idRewards = idRewards;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Typeofreward getTypeofreward() {
		return this.typeofreward;
	}

	public void setTypeofreward(Typeofreward typeofreward) {
		this.typeofreward = typeofreward;
	}

}