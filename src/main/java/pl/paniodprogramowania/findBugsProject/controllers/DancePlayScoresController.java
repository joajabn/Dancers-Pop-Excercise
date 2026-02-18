package pl.paniodprogramowania.findBugsProject.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreDetails;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreResponse;

@RestController
@RequestMapping("/v1")
public class DancePlayScoresController {

  @GetMapping(path = "/dancers/{dancerId}/scores")
  public ResponseEntity<DancePlayScoreResponse> getDancersScores(
      @PathVariable("dancerId") int dancerId
  ) {
    // FIXME - return real values
    // we want to return list of details consisting of:\
    // dancer full name that is `{name} {surname}`
    // their id
    // list of the plays the dancer was dancing in and their average rating together with info how many ratings there were
    // we want it to be sorted by dancePlayId
    // example below

    var response =
        DancePlayScoreResponse.builder()
            .dancerId(dancerId)
            .details(List.of(
                DancePlayScoreDetails.builder()
                    .dancePlayId(1)
                    .score(4.99)
                    .nrOfRatings(3)
                    .build()
                ,
                DancePlayScoreDetails.builder()
                    .dancePlayId(2)
                    .score(2.99)
                    .nrOfRatings(5)
                    .build()
            ))
            .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
