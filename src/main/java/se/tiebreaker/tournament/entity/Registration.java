package se.tiebreaker.tournament.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Anders Strand
 */
@Entity
@Setter
@Getter
public class Registration {

	@Id
	@SequenceGenerator(name="registration_generator", sequenceName = "registration_seq")
	@GeneratedValue(generator = "registration_seq")
	@Column
	private long id;

	@ManyToOne
	@JoinColumn(name="draw_id")
	private Draw draw;

	@OneToOne
	@JoinColumn(name="player_id")
	private Player player;

}
