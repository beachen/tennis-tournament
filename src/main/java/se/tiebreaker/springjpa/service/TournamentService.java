package se.tiebreaker.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.tiebreaker.springjpa.entity.Tournament;
import se.tiebreaker.springjpa.repository.TournamentRepository;

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
		if(existing != null){
			existing.setDraws(tournament.getDraws());
			em.merge(existing.getDraws());
		}
		else{
			em.persist(tournament);
		}
	}
}
