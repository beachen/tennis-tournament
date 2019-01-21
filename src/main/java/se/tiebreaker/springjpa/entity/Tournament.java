package se.tiebreaker.springjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "draw_id")
	private List<Draw> draws;

	public Tournament() {

	}

	public Tournament(String name, LocalDate date, String surface, String city) {

		this.name = name;
		this.date = date;
		this.surface = surface;
		this.city = city;
	}

	public List<Draw> getDraws() {

		return draws;
	}

	public void setDraws(List<Draw> draws) {

		this.draws = draws;
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

	public LocalDate getDate() {

		return date;
	}

	public void setDate(LocalDate date) {

		this.date = date;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tournament that = (Tournament) o;
		return id == that.id &&
			name.equals(that.name) &&
			date.equals(that.date) &&
			draws.equals(that.draws);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, date);
	}
}
