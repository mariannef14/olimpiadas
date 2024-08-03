package com.atletasbr.olimpiadas.service.modality;

import com.atletasbr.olimpiadas.config.exception.handlers.DataAlreadyExistsException;
import com.atletasbr.olimpiadas.config.exception.handlers.DataNotFoundException;
import com.atletasbr.olimpiadas.controller.dto.request.ModalityRequest;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventResponse;
import com.atletasbr.olimpiadas.model.ModalityModel;
import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;
import com.atletasbr.olimpiadas.repository.ModalityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ModalityService implements IModalityService {

    private final ModalityRepository repository;


    public ModalityService(ModalityRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<ModalityModel> save(ModalityRequest request) {

        List<ModalityModel> modalityList = new ArrayList<>();


        for (EventTypeEnum event: request.eventType()){

            if (verifyEventType(event)) {
                throw new DataAlreadyExistsException();
            }

            var modality = new ModalityModel();
            modality.setName(request.name());
            modality.setEventType(event);

            modalityList.add(repository.save(modality));


        }

        return modalityList;

    }


    @Override
    public ModalityModel findById(UUID id) {

        return repository.findById(id).orElseThrow(DataNotFoundException::new);

    }


    @Override
    public List<ModalityModel> findByName(String modality) {

        var modalityList = repository.findByName(modality);

        if (modalityList.isEmpty())
            throw new DataNotFoundException();

        return modalityList;

    }


    @Override
    public ModalityModel findByNameAndEventType(String name, String eventType) {

        return repository.findByNameAndEventType(name.toUpperCase(),
                            EventTypeEnum.valueOf(eventType.trim().toUpperCase().replace(" ", "_")))
                        .orElseThrow(DataNotFoundException::new);

    }


    @Override
    public Set<ModalityEventResponse> findAll() {

        return repository.findAll()
                         .stream()
                         .map(ModalityEventResponse::new)
                         .collect(Collectors.toSet());

    }



    private boolean verifyEventType(EventTypeEnum eventType) {

        return repository.existsByEventType(eventType);

    }

}