package pl.paniodprogramowania.findBugsProject.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DancerRating(
        int id,
        DancePlay dancePlay,
        Dancer dancer,
        LocalDateTime dateOfRating,
        int rating
) {
}

