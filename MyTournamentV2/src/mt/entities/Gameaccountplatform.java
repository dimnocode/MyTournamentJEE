package mt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gameaccountplatforms database table.
 * 
 */
@Entity
@Table(name="gameaccountplatforms")
@NamedQueries({
	@NamedQuery (name="Gameaccountplatform.findAll", query="SELECT g FROM Gameaccountplatform g"),
	@NamedQuery (name="Gameaccountplatform.find", query="SELECT g FROM Gameaccountplatform g WHERE g.idGameAccountPlatforms = :idGameAccountPlatforms")
})
public class Gameaccountplatform implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idGameAccountPlatforms;

	private boolean active;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Gameaccount
	@OneToMany(mappedBy="gameaccountplatform")
	private List<Gameaccount> gameaccounts;

	public Gameaccountplatform() {
	}

	public int getIdGameAccountPlatforms() {
		return this.idGameAccountPlatforms;
	}

	public void setIdGameAccountPlatforms(int idGameAccountPlatforms) {
		this.idGameAccountPlatforms = idGameAccountPlatforms;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gameaccount> getGameaccounts() {
		return this.gameaccounts;
	}

	public void setGameaccounts(List<Gameaccount> gameaccounts) {
		this.gameaccounts = gameaccounts;
	}

	public Gameaccount addGameaccount(Gameaccount gameaccount) {
		getGameaccounts().add(gameaccount);
		gameaccount.setGameaccountplatform(this);

		return gameaccount;
	}

	public Gameaccount removeGameaccount(Gameaccount gameaccount) {
		getGameaccounts().remove(gameaccount);
		gameaccount.setGameaccountplatform(null);

		return gameaccount;
	}

}