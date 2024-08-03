package com.atletasbr.olimpiadas.service.athlete;

import com.atletasbr.olimpiadas.config.exception.handlers.DataAlreadyExistsException;
import com.atletasbr.olimpiadas.config.exception.handlers.DataNotFoundException;
import com.atletasbr.olimpiadas.controller.dto.request.AthleteRequest;
import com.atletasbr.olimpiadas.controller.dto.response.AthleteResponse;
import com.atletasbr.olimpiadas.model.AthleteModel;
import com.atletasbr.olimpiadas.repository.AthleteRepository;
import com.atletasbr.olimpiadas.service.modality.ModalityService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class AtheteService implements IAthleteService{

    private final AthleteRepository repository;
    private final ModalityService modalityService;



    public AtheteService(AthleteRepository repository, ModalityService modalityService) {
        this.repository = repository;
        this.modalityService = modalityService;
    }



    @Override
    public AthleteModel save(AthleteRequest request) {

        if(verifyRegistrationNumber(request.registrationNumber()))
            throw new DataAlreadyExistsException();

        var modality = modalityService.findByNameAndEventType(request.modality(), request.eventType());

        var athleteModel = new AthleteModel();
        BeanUtils.copyProperties(request, athleteModel);
        athleteModel.setModality(modality);

        return repository.save(athleteModel);

    }


    @Override
    public AthleteModel findById(UUID id) {

        return repository.findById(id).orElseThrow(DataNotFoundException::new);

    }


    @Override
    public Set<AthleteResponse> findByName(String name) {

        var athleteList = repository.findByName(name);

        if (athleteList.isEmpty())
            throw new DataNotFoundException();

        return athleteList.stream()
                          .map(AthleteResponse::new)
                          .collect(Collectors.toSet());

    }


    @Override
    public Set<AthleteResponse> findAll() {

        return repository.findAll()
                        .stream()
                        .map(AthleteResponse::new)
                        .collect(Collectors.toSet());

    }



    public boolean verifyRegistrationNumber(Integer number) {

        return repository.existsByRegistrationNumber(number);

    }

}