package pl.paniodprogramowania.findBugsProject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayResponse;

@RestController
@RequestMapping("/v1")
public class DancePlayController {

  @GetMapping("/danceplays")
  public ResponseEntity<DancePlayResponse> getDancePlays() {
    return ResponseEntity.ok(new DancePlayResponse());
  }
}
