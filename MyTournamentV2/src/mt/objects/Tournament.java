package mt.objects;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tournaments database table.
 * 
 */
@Entity
@Table(name="tournaments")
@NamedQuery(name="Tournament.findAll", query="SELECT t FROM Tournament t")
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTournaments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	private Time hours;

	private int idFormatTournaments;

	private int idLocations;

	private int idTypeOfTournaments;

	private int maxPlayers;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	private String name;

	private byte online;

	private float price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	//bi-directional many-to-one association to Selection
	@OneToMany(mappedBy="tournament")
	private List<Selection> selections;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="idGames")
	private Game game;

	public Tournament() {
	}

	public int getIdTournaments() {
		return this.idTournaments;
	}

	public void setIdTournaments(int idTournaments) {
		this.idTournaments = idTournaments;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getHours() {
		return this.hours;
	}

	public void setHours(Time hours) {
		this.hours = hours;
	}

	public int getIdFormatTournaments() {
		return this.idFormatTournaments;
	}

	public void setIdFormatTournaments(int idFormatTournaments) {
		this.idFormatTournaments = idFormatTournaments;
	}

	public int getIdLocations() {
		return this.idLocations;
	}

	public void setIdLocations(int idLocations) {
		this.idLocations = idLocations;
	}

	public int getIdTypeOfTournaments() {
		return this.idTypeOfTournaments;
	}

	public void setIdTypeOfTournaments(int idTypeOfTournaments) {
		this.idTypeOfTournaments = idTypeOfTournaments;
	}

	public int getMaxPlayers() {
		return this.maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Date getModificationDate() {
		return this.modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getOnline() {
		return this.online;
	}

	public void setOnline(byte online) {
		this.online = online;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Selection> getSelections() {
		return this.selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public Selection addSelection(Selection selection) {
		getSelections().add(selection);
		selection.setTournament(this);

		return selection;
	}

	public Selection removeSelection(Selection selection) {
		getSelections().remove(selection);
		selection.setTournament(null);

		return selection;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}