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
public class Draw {

	@Id
	@SequenceGenerator(name="draw_generator", sequenceName = "draw_seq")
	@GeneratedValue(generator = "draw_seq")
	@Column
	private long id;

	@Column
	private String name;

	public Draw(String name) {

		this.name = name;
	}

	public Draw() {

	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id")
	private List<Player> players;

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public List<Player> getPlayers() {

		return players;
	}

	public void setPlayers(List<Player> players) {

		this.players = players;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}
}
