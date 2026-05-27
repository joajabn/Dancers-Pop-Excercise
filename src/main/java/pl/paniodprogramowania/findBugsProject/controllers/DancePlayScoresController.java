package pl.paniodprogramowania.findBugsProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreDetails;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreResponse;
import pl.paniodprogramowania.findBugsProject.services.DancePlayScoreService;

@RestController
@RequestMapping("/v1")
public class DancePlayScoresController {

    private DancePlayScoreService dancePlayScoreService;

    public DancePlayScoresController(@Autowired DancePlayScoreService dancePlayScoreService) {
        this.dancePlayScoreService = dancePlayScoreService;
    }

    @GetMapping(path = "/dancers/{dancerId}/scores")
  public ResponseEntity<DancePlayScoreResponse> getDancersScores(
      @PathVariable("dancerId") int dancerId
  ) {
        DancePlayScoreResponse response = dancePlayScoreService.getDancerStats(dancerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
