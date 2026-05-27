package pl.paniodprogramowania.findBugsProject.model;

import lombok.Builder;

@Builder
public record DancerDetails(
        int id,
        String cityOfBirth,
        int yearOfBirth
) {
}
