package pl.paniodprogramowania.findBugsProject.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancerResponse;
import pl.paniodprogramowania.findBugsProject.entities.DancePlayEntity;
import pl.paniodprogramowania.findBugsProject.entities.DancerDetailsEntity;
import pl.paniodprogramowania.findBugsProject.entities.DancerEntity;
import pl.paniodprogramowania.findBugsProject.model.DancePlay;
import pl.paniodprogramowania.findBugsProject.model.Dancer;
import pl.paniodprogramowania.findBugsProject.model.DancerDetails;

@Component
@Mapper(componentModel = "spring")
public interface DancerMapper {

    @Mappings(
            {
                    @Mapping(source = "dancerId", target = "id"),
                    @Mapping(source = "firstName", target = "firstName"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "preferredDance", target = "preferredDance"),
                    @Mapping(expression = "java(dancerEntity.getFirstName() + \" \" + dancerEntity.getLastName())", target = "fullName"),
                    @Mapping(expression = "java(java.time.Year.now().getValue() - dancerEntity.getDancerDetails().getYearOfBirth())", target = "age"),
                    @Mapping(source = "dancerDetails", target = "dancerDetails"),
                    @Mapping(target = "dancePlays", ignore = true)

            })
    Dancer toDancer(DancerEntity dancerEntity);

    @Mappings(
            {
                    @Mapping(source = "dancePlayId", target = "id"),
                    @Mapping(source = "title", target = "title"),
                    @Mapping(target = "primaballerina", ignore = true)
            })
    DancePlay toDancePlay(DancePlayEntity dancerDocument);

    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "firstName", target = "firstName"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "preferredDance", target = "preferredDance")
            })
    DancerResponse toDancerResponse(Dancer dancerDocument);

    @Mappings({
            @Mapping(source = "dancerDetailsId", target = "id"),
            @Mapping(source = "cityOfBirth", target = "cityOfBirth"),
            @Mapping(source = "yearOfBirth", target = "yearOfBirth")
    })
    DancerDetails toDancerDetails(DancerDetailsEntity dancerDetailsEntity);

}

