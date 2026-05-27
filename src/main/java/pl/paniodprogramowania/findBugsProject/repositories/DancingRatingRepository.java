package pl.paniodprogramowania.findBugsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.paniodprogramowania.findBugsProject.entities.DancerRatingEntity;

@Repository
public interface DancingRatingRepository extends JpaRepository<DancerRatingEntity, Long> {
}
