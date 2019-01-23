package se.tiebreaker.tournament;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.tiebreaker.tournament.entity.Player;

/**
 * @author Anders Strand
 */
public class AddPlayer {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplateBuilder().build();

		// Add new player to draw
		int tournamentId = 1;
		Player player = new Player("Marina", "Strand");

		ResponseEntity<String> addedPlayer =
			template.postForEntity("http://localhost:8080/tournaments/players", player, String.class);

	}
}
