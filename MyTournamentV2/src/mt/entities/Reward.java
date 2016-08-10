package mt.entities;

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
	private int idRewards;

	private String name;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="Tournaments_idTournaments")
	private Tournament tournament;

	//bi-directional many-to-one association to Typeofreward
	@ManyToOne
	@JoinColumn(name="idTypeOfRewards")
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