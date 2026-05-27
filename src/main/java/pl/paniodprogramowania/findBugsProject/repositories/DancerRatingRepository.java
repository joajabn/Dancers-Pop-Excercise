package pl.paniodprogramowania.findBugsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paniodprogramowania.findBugsProject.entities.DancerRatingEntity;

import java.util.List;

@Repository
public interface DancerRatingRepository extends JpaRepository<DancerRatingEntity, Long> {
    List<DancerRatingEntity> findAllByDancer_DancerId(Long dancerId);
}
