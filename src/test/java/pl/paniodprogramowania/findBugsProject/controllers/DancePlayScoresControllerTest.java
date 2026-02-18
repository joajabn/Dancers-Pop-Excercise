package pl.paniodprogramowania.findBugsProject.controllers;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import jakarta.transaction.Transactional;
import java.time.Year;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DancePlayScoresControllerTest {


  @LocalServerPort
  int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  @Transactional
  public void shouldReturnProperDancerStats() {

    given()
        .port(port)
        .headers("Content-Type", "application/json")
        .when()
        .get("v1/dancers/1/scores")
        .then()
        .assertThat()
        .statusCode(HttpStatus.OK.value())
        .body("dancerId", Matchers.is(1))
        .body("dancerFullName", Matchers.is("Maria Xiovskaya"))
        .body("dancerAge", Matchers.is(Year.now().getValue() - 1980))
        .body("dancerOriginCity", Matchers.is("Kyev"))

        .body("details", Matchers.hasSize(2))

        .body("details[0].dancePlayId", Matchers.is(1))
        .body("details[0].score", Matchers.is(4.5))
        .body("details[0].nrOfRatings", Matchers.is(2))

        .body("details[1].dancePlayId", Matchers.is(2))
        .body("details[1].score", Matchers.is(3))
        .body("details[1].nrOfRatings", Matchers.is(3));
  }
}