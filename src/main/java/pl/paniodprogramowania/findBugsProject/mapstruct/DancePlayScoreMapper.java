package pl.paniodprogramowania.findBugsProject.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreResponse;
import pl.paniodprogramowania.findBugsProject.model.Dancer;

@Component
@Mapper(componentModel = "spring")
public interface DancePlayScoreMapper {

    @Mappings({
            @Mapping(source = "id", target = "dancerId"),
            @Mapping(source = "fullName", target = "dancerFullName"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "dancerDetails.cityOfBirth", target = "city"),
            @Mapping(target = "details", ignore = true)
    })
    DancePlayScoreResponse toScoreResponse(Dancer dancer);
}
