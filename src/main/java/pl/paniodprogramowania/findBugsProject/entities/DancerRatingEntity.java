package pl.paniodprogramowania.findBugsProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dancer_rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DancerRatingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dancer_rating_id")
  private Integer dancerRatingId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dance_play_id", nullable = false)
  private DancePlayEntity dancePlay;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dancer_id", nullable = false)
  private DancerEntity dancer;

  @Column(name = "date_of_rating", nullable = false)
  private LocalDateTime dateOfRating;

  @Column(name = "rating")
  private Integer rating;
}