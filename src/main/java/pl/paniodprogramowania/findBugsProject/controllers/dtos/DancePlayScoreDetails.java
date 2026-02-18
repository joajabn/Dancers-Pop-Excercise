package pl.paniodprogramowania.findBugsProject.controllers.dtos;

import lombok.Builder;

@Builder
public record DancePlayScoreDetails(
    int dancePlayId,
    double score,
    int nrOfRatings
) {
}
