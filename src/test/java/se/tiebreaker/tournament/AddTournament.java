package se.tiebreaker.tournament;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.tiebreaker.tournament.entity.Draw;
import se.tiebreaker.tournament.entity.Player;
import se.tiebreaker.tournament.entity.Tournament;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anders Strand
 */
public class AddTournament {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplateBuilder().build();

		String response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);

		Tournament tournament = new Tournament("Wimbledon", LocalDate.now(), "Grass", "London");
		List<Draw> draws = new ArrayList<>();

		Draw mens = createMensSingles();
		Draw womens = createWomenSingles();
		draws.add(mens);
		draws.add(womens);



		ResponseEntity<String> upload = template.postForEntity(
			"http://localhost:8080/tournaments/add",
			tournament,
			String.class);

		System.out.println(upload);

		response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);

		// Add new player to draw
		int tournamentId = 1;
		Player player = new Player("Anders", "Strand");

		ResponseEntity<String> addedPlayer =
			template.postForEntity("http://localhost:8080/tournaments/players", player, String.class);

		response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);

	}

	private static Draw createMensSingles() {

		Draw draw = new Draw();
		draw.setName("Men's singles");
		/*
		draw.setPlayers(Arrays.asList(
			new Player("Roger", "Federer"),
			new Player("Rafael", "Nadal"),
			new Player("Novak", "Djokovic"),
			new Player("Andy", "Murray"),
			new Player("Grigor", "Dimitrov"),
			new Player("Milos", "Raonic"))); */
		return draw;
	}

	private static Draw createWomenSingles() {

		Draw draw = new Draw();
		/*
		draw.setName("Women's singles");
		draw.setPlayers(Arrays.asList(
			new Player("Serena", "Williams"),
			new Player("Simona", "Halep"))); */

		return draw;
	}

}
