package se.tiebreaker.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Anders Strand
 */
@Entity
public class Player {

	@Id
	@SequenceGenerator(name="player_generator", sequenceName = "player_seq", allocationSize=50)
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
