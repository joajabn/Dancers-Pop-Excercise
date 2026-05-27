package pl.paniodprogramowania.findBugsProject.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Builder;

@Builder
public record DancePlayScoreResponse(
        int dancerId,
        String dancerFullName,
        @JsonProperty("dancerAge")
        int age,
        @JsonProperty("dancerOriginCity")
        String city,
        List<DancePlayScoreDetails> details
) {
    public DancePlayScoreResponse withDetails(List<DancePlayScoreDetails> details) {
        return new DancePlayScoreResponse(dancerId, dancerFullName, age, city, details);
    }
}
