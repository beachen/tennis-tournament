package se.tiebreaker.tournament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.tiebreaker.tournament.entity.Player;
import se.tiebreaker.tournament.entity.Tournament;
import se.tiebreaker.tournament.repository.TournamentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anders Strand
 */
@Service
public class TournamentService {

	@Autowired
	TournamentRepository repo;

	@PersistenceContext
	private EntityManager em;

	public List<Tournament> getTournaments() {

		Iterable<Tournament> t = repo.findAll();
		List<Tournament> all = new ArrayList<>();
		t.forEach(all::add);
		return all;
	}

	@Transactional
	public void save(Tournament tournament) {

		Tournament existing = repo.findByName(tournament.getName());
		if (existing != null) {
			em.merge(existing);
		}
		else {
			em.persist(tournament);
			// Update ManyToOne relationship
			tournament.getDraws().forEach(draw -> {
				draw.setTournament(tournament);
				em.persist(draw);
			});
		}
	}
	@Transactional
	public void addPlayer(int id, Player player) {

		//Optional<Tournament> tournament = repo.findById((long) id);
		//Tournament t = tournament.get();
//		List<Draw> allDraws = t.getDraws();
//		t.getDraws().get(0).setPlayers(List.of(player));
//		em.merge(t);
	}
}
