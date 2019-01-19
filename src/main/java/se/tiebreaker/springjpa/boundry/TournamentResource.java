package se.tiebreaker.springjpa.boundry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.tiebreaker.springjpa.entity.Tournament;
import se.tiebreaker.springjpa.service.TournamentService;

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
	@PostMapping("/add")
	public void getTournaments(Tournament tournament){

		this.service.save(tournament);
	}


}
