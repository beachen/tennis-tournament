package se.tiebreaker.tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.tiebreaker.tournament.entity.Tournament;

/**
 * @author Anders Strand
 */
@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

	public Tournament findByName(String name);

}
