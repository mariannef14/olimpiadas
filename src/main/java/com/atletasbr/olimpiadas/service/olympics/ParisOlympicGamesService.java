package com.atletasbr.olimpiadas.service.olympics;

import com.atletasbr.olimpiadas.config.exception.handlers.DataNotFoundException;
import com.atletasbr.olimpiadas.controller.dto.request.OlympicGamesRequest;
import com.atletasbr.olimpiadas.model.ModalityModel;
import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;
import com.atletasbr.olimpiadas.repository.ParisOlympicGamesRepository;
import com.atletasbr.olimpiadas.service.athlete.IAthleteService;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ParisOlympicGamesService implements IParisOlympicGamesService {

    private final ParisOlympicGamesRepository repository;
    private final IAthleteService athleteService;


    public ParisOlympicGamesService(ParisOlympicGamesRepository repository, IAthleteService athleteService){

        this.repository = repository;
        this.athleteService = athleteService;

    }



    @Override
    @Transactional
    public ParisOlympicGamesModel save(OlympicGamesRequest request) {

        var athlete = athleteService.save(request.athlete());

        var wonMedal = updateTotalMedals(request.position());

        if (wonMedal) {

            athlete.setTotalMedals(athlete.getTotalMedals() + 1);

        }


        var local = verifyLocalOfModality(athlete.getModality().getName());


        var olympicsModel = new ParisOlympicGamesModel();
        BeanUtils.copyProperties(request, olympicsModel);
        olympicsModel.setName(local);
        olympicsModel.setAthlete(athlete);
        olympicsModel.setModality(athlete.getModality());
        olympicsModel.setEventId(athlete.getModality().getEventType());


        return repository.save(olympicsModel);

    }

    @Override
    public ParisOlympicGamesModel findById(UUID id) {

        return repository.findById(id).orElseThrow(DataNotFoundException::new);

    }


    @Override
    public List<ParisOlympicGamesModel> findAll(String athleteName, String modality, String eventType) {

        return repository.findAll((root, query, builder) -> {{

            List<Predicate> predicates = new ArrayList<>();
            Root<ModalityModel> modalityRoot = query.from(ModalityModel.class);

            if (Objects.nonNull(athleteName) && !athleteName.isBlank()){
                predicates.add(builder.like(builder.upper(root.get("athlete").get("name")),
                        "%" + athleteName.trim().toUpperCase() + "%"));
            }

            if (Objects.nonNull(modality) && !modality.isBlank()){
                predicates.add(builder.like(builder.upper(root.get("modality").get("name")),
                        "%" + modality.trim().toUpperCase() + "%"));
            }

            if (Objects.nonNull(eventType) && !eventType.isBlank()){
                predicates.add(builder.like(builder.upper(modalityRoot.get("eventType")),
                        "%" + eventType.trim().toUpperCase().replace(" ", "_") + "%"));
            }

            return builder.and(predicates.stream().toArray(Predicate[]::new));

        }});

    }



    private String verifyLocalOfModality(String modality) {

        var modalityName = modality.trim().toUpperCase().replace(" ", "_");

        if (modalityName.equals("SKATE") || modalityName.equals("BREAKING") || modalityName.equals("CICLISMO_BMX_FREESTYLE")
            || modalityName.equals("BASQUETE")){
            return "Place de la Concorde";
        } else if (modalityName.equals("BADMINTON") || modalityName.equals("GINASTICA_RITMICA")) {
                return "Arena Porte de la Chapelle";
        }

        else return "Paris";

    }


    private boolean updateTotalMedals(int position) {

        return position >= 1 && position <= 3;

    }

}