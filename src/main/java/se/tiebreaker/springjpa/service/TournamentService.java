package se.tiebreaker.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.tiebreaker.springjpa.entity.Draw;
import se.tiebreaker.springjpa.entity.Player;
import se.tiebreaker.springjpa.entity.Tournament;
import se.tiebreaker.springjpa.repository.TournamentRepository;

import java.time.LocalDate;
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
		return all;
	}
	public void save(Tournament tournament){

		Tournament wimbledon = new Tournament("Wimbledon", LocalDate.of(2019, 6,20), "Grass", "London");
		Tournament rolanGarros = new Tournament("Roland Garros", LocalDate.of(2019, 5,20), "Clay", "Paris");

  		Draw mensSingles = new Draw("Mens Singles");
		mensSingles.setPlayers(new ArrayList<>());
		mensSingles.getPlayers().add(new Player("Roger", "Federer"));
		mensSingles.getPlayers().add(new Player("Rafael", "Nadal"));
		wimbledon.setDraws(Arrays.asList(mensSingles));

		repo.save(wimbledon);
		repo.save(rolanGarros);
	}
}
