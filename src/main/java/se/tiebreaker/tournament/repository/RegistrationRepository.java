package se.tiebreaker.tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.tiebreaker.tournament.entity.Registration;
import se.tiebreaker.tournament.entity.Tournament;

/**
 * @author Anders Strand
 */
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

	public Registration findByIdAndAndTournamentId(long id, long tid);
}
