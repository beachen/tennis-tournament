package se.tiebreaker.tournament.boundry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.tiebreaker.tournament.entity.Player;
import se.tiebreaker.tournament.entity.Tournament;
import se.tiebreaker.tournament.service.TournamentService;

import java.util.List;

/**
 * @author Anders Strand
 */

@RestController
@RequestMapping("/tournaments")
public class TournamentResource {

	@Autowired
	TournamentService service;

	@GetMapping("/all")
	public List<Tournament> getTournaments(){

		return this.service.getTournaments();
	}
	@PostMapping(path="/add", consumes = "application/json")
	public void getTournaments(@RequestBody Tournament tournament){

		this.service.save(tournament);
	}

	@PostMapping(path="/players", consumes = "application/json")
	public void getTournaments(@RequestBody Player player){

		service.addPlayer(1, player);


	}


}
