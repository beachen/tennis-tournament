package se.tiebreaker.springjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.tiebreaker.springjpa.entity.Tournament;

/**
 * @author Anders Strand
 */
@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
