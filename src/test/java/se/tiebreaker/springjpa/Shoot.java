package se.tiebreaker.springjpa;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.tiebreaker.springjpa.entity.Tournament;

import java.time.LocalDate;

/**
 * @author Anders Strand
 */
public class Shoot {

	public static void main(String[] args) {

		RestTemplate template = new RestTemplateBuilder()
			.build();

		String response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);

		ResponseEntity<String> upload = template.postForEntity(
			"http://localhost:8080/tournaments/add",
			new Tournament("Wimbledon", LocalDate.now(), "Grass", "London"),
			String.class);

		System.out.println(upload);

		response = template.getForObject("http://localhost:8080/tournaments/all", String.class);
		System.out.println(response);
	}

}
