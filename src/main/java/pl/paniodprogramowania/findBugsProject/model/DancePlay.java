package pl.paniodprogramowania.findBugsProject.model;

import lombok.Builder;

@Builder
public record DancePlay(long id, String title, Dancer primaballerina) {
}
