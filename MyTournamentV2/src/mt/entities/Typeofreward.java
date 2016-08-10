package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeofrewards database table.
 * 
 */
@Entity
@Table(name="typeofrewards")
@NamedQuery(name="Typeofreward.findAll", query="SELECT t FROM Typeofreward t")
public class Typeofreward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTypeOfRewards;

	private String name;

	//bi-directional many-to-one association to Reward
	@OneToMany(mappedBy="typeofreward")
	private List<Reward> rewards;

	public Typeofreward() {
	}

	public int getIdTypeOfRewards() {
		return this.idTypeOfRewards;
	}

	public void setIdTypeOfRewards(int idTypeOfRewards) {
		this.idTypeOfRewards = idTypeOfRewards;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reward> getRewards() {
		return this.rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public Reward addReward(Reward reward) {
		getRewards().add(reward);
		reward.setTypeofreward(this);

		return reward;
	}

	public Reward removeReward(Reward reward) {
		getRewards().remove(reward);
		reward.setTypeofreward(null);

		return reward;
	}

}