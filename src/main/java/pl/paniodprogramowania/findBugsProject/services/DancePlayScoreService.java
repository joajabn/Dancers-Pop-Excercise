package pl.paniodprogramowania.findBugsProject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreDetails;
import pl.paniodprogramowania.findBugsProject.controllers.dtos.DancePlayScoreResponse;
import pl.paniodprogramowania.findBugsProject.entities.DancerEntity;
import pl.paniodprogramowania.findBugsProject.entities.DancerRatingEntity;
import pl.paniodprogramowania.findBugsProject.exceptions.DancerNotFoundException;
import pl.paniodprogramowania.findBugsProject.mapstruct.DancePlayScoreMapper;
import pl.paniodprogramowania.findBugsProject.mapstruct.DancerMapper;
import pl.paniodprogramowania.findBugsProject.model.Dancer;
import pl.paniodprogramowania.findBugsProject.repositories.DancersRepository;
import pl.paniodprogramowania.findBugsProject.repositories.DancerRatingRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DancePlayScoreService {

    private DancersRepository dancersRepository;
    private DancerRatingRepository dancerRatingRepository;
    private DancerMapper dancerMapper;
    private DancePlayScoreMapper dancePlayScoreMapper;

    public DancePlayScoreService(@Autowired DancersRepository dancersRepository, @Autowired DancerRatingRepository dancingRatingRepository, @Autowired DancerMapper dancerMapper, @Autowired DancePlayScoreMapper dancePlayScoreMapper) {
        this.dancersRepository = dancersRepository;
        this.dancerRatingRepository = dancingRatingRepository;
        this.dancerMapper = dancerMapper;
        this.dancePlayScoreMapper = dancePlayScoreMapper;
    }

    public DancePlayScoreResponse getDancerStats(long dancerId){
        DancerEntity dancerEntity = dancersRepository.findById(dancerId)
                .orElseThrow(() -> new DancerNotFoundException(dancerId));
        Dancer dancer  = dancerMapper.toDancer(dancerEntity);


        List<DancePlayScoreDetails> details = dancerRatingRepository
                .findAllByDancer_DancerId(dancerId)
                .stream()
                .collect(Collectors.groupingBy(rating -> rating.getDancePlay().getDancePlayId()))
                .entrySet().stream()
                .map(entry -> {
                    List<DancerRatingEntity> playRatings = entry.getValue();
                    double avgScore = playRatings.stream()
                            .mapToInt(DancerRatingEntity::getRating)
                            .average()
                            .orElse(0.0);
                    return DancePlayScoreDetails.builder()
                            .dancePlayId(entry.getKey().intValue())
                            .score(avgScore)
                            .nrOfRatings(playRatings.size())
                            .build();
                })
                .sorted(Comparator.comparing(DancePlayScoreDetails::dancePlayId))
                .toList();

        return dancePlayScoreMapper.toScoreResponse(dancer).withDetails(details);
    }
}
