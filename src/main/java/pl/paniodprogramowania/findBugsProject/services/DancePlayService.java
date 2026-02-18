package pl.paniodprogramowania.findBugsProject.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paniodprogramowania.findBugsProject.model.DancePlay;
import pl.paniodprogramowania.findBugsProject.repositories.DancePlayRepository;

@Service
public class DancePlayService {

  private DancePlayRepository dancePlayRepository;

  public DancePlayService(@Autowired DancePlayRepository dancePlayRepository) {
    this.dancePlayRepository = dancePlayRepository;
  }

  public List<DancePlay> getAllDancePlays() {
    return List.of();
  }
}
