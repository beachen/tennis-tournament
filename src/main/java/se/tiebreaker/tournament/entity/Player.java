package se.tiebreaker.tournament.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * @author Anders Strand
 */
@Entity
public class Player implements Serializable {

	@Id
	@SequenceGenerator(name="player_generator", sequenceName = "player_seq")
	@GeneratedValue(generator = "player_seq")
	@Column
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Player(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Player() {

	}

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}
}
