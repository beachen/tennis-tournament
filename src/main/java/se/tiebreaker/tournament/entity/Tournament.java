package se.tiebreaker.tournament.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Anders Strand
 */
@Entity
@Data
@Getter
@Setter
public class Tournament implements Serializable {

	@Id
	@GeneratedValue(generator = "tournament_seq")
	@SequenceGenerator(name="tournament_generator", sequenceName = "tournament_seq")
	@Column
	private long id;

	@Column(nullable = false)
	private String name;

	@Column
	private LocalDate date;

	@Column(nullable = false)
	private String surface;

	@Column(nullable = false)
	private String city;

	//@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<Draw> draws;


	public Tournament() {

	}

	public Tournament(String name, LocalDate date, String surface, String city) {

		this.name = name;
		this.date = date;
		this.surface = surface;
		this.city = city;
	}

}
