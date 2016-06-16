package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typegameaccounts database table.
 * 
 */
@Entity
@Table(name="typegameaccounts")
@NamedQuery(name="Typegameaccount.findAll", query="SELECT t FROM Typegameaccount t")
public class Typegameaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTypeGameAccounts;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Gameaccount
	@OneToMany(mappedBy="typegameaccount")
	private List<Gameaccount> gameaccounts;

	public Typegameaccount() {
	}

	public int getIdTypeGameAccounts() {
		return this.idTypeGameAccounts;
	}

	public void setIdTypeGameAccounts(int idTypeGameAccounts) {
		this.idTypeGameAccounts = idTypeGameAccounts;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Gameaccount> getGameaccounts() {
		return this.gameaccounts;
	}

	public void setGameaccounts(List<Gameaccount> gameaccounts) {
		this.gameaccounts = gameaccounts;
	}

	public Gameaccount addGameaccount(Gameaccount gameaccount) {
		getGameaccounts().add(gameaccount);
		gameaccount.setTypegameaccount(this);

		return gameaccount;
	}

	public Gameaccount removeGameaccount(Gameaccount gameaccount) {
		getGameaccounts().remove(gameaccount);
		gameaccount.setTypegameaccount(null);

		return gameaccount;
	}

}