package se.tiebreaker.springjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

/**
 * @author Anders Strand
 */
@Entity
public class Tournament {

	@Id
	@GeneratedValue(generator = "tournament_seq")
	@SequenceGenerator(name="tournament_generator", sequenceName = "tournament_seq", allocationSize=50)
	@Column
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surface;

	@Column(nullable = false)
	private String city;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "player_id")
	private List<Player> players;

	public Tournament() {

	}

	public Tournament(String name, String surface, String city) {

		this.name = name;
		this.surface = surface;
		this.city = city;

	}

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public List<Player> getPlayers() {

		return players;
	}

	public void setPlayers(List<Player> players) {

		this.players = players;
	}

	public String getSurface() {

		return surface;
	}

	public void setSurface(String surface) {

		this.surface = surface;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}
}
