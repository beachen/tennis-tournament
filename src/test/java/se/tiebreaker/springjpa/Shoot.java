package se.tiebreaker.springjpa;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.tiebreaker.springjpa.entity.Draw;
import se.tiebreaker.springjpa.entity.Player;
import se.tiebreaker.springjpa.entity.Tournament;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anders Strand
 */
public class Shoot {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplateBuilder().build();

		String response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);

		Tournament tournament = new Tournament("Wimbledon2", LocalDate.now(), "Grass", "London");
		List<Draw> draws = new ArrayList<>();
		Draw draw = new Draw();
		draw.setName("Mens singles");
		Player djokovic = new Player("Roger", "asdf");
		Player dimitrov = new Player("Rafael", "asdf");
		draw.setPlayers(Arrays.asList(djokovic, dimitrov));
		draws.add(draw);
		tournament.setDraws(draws);

		ResponseEntity<String> upload = template.postForEntity(
			"http://localhost:8080/tournaments/add",
			tournament,
			String.class);

		System.out.println(upload);

		response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);
	}

}
