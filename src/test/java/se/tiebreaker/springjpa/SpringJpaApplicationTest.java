package se.tiebreaker.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import se.tiebreaker.springjpa.entity.Tournament;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Anders Strand
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJpaApplicationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void verifyTournament(){

		// 1
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/tournaments/all", String.class);
		System.out.println("All tournaments" +  response);

		// 2
		ResponseEntity<String> upload = this.restTemplate.postForEntity(
			"http://localhost:" + port + "/tournaments/add",
			new Tournament("Wimbledon", LocalDate.now(), "Grass", "London"),
			String.class);

		String tournamnets = this.restTemplate.getForObject("http://localhost:" + port + "/tournaments/all", String.class);
		System.out.println("All tournaments:" + tournamnets);
		assertTrue(tournamnets != null);
	}

}