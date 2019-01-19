package se.tiebreaker.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.tiebreaker.springjpa.entity.Player;
import se.tiebreaker.springjpa.entity.Tournament;
import se.tiebreaker.springjpa.repository.TournamentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anders Strand
 */
@Service
public class TournamentService {

	@Autowired
	TournamentRepository repo;

	public List<Tournament> getTournaments(){

		Iterable<Tournament> t = repo.findAll();
		List<Tournament> all = new ArrayList<>();
		t.forEach(all::add);

		save();
	    return all;
	}
	public void save(){

		Tournament t = new Tournament("Wimbledon", "Grass", "London");
		t.setPlayers(Arrays.asList(
			new Player("Roger", "Federer"),
			new Player("Rafael", "Nadal")));

		repo.save(t);
	}


}
