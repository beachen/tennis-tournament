package se.tiebreaker.tournament.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Anders Strand
 */
@Entity
@Data
@Getter
@Setter
public class Draw {

	@Id
	@SequenceGenerator(name="draw_generator", sequenceName = "draw_seq")
	@GeneratedValue(generator = "draw_seq")
	@Column
	private long id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	public Draw(String name) {

		this.name = name;
	}
	public Draw() {

	}
}
