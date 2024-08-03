package com.atletasbr.olimpiadas.service.modality;


import com.atletasbr.olimpiadas.controller.dto.request.ModalityRequest;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventResponse;
import com.atletasbr.olimpiadas.model.ModalityModel;

import java.util.List;
import java.util.Set;
import java.util.UUID;


public interface IModalityService {

    List<ModalityModel> save(ModalityRequest request);

    ModalityModel findById(UUID id);

    Set<ModalityEventResponse> findAll();

    List<ModalityModel> findByName(String modality);

    ModalityModel findByNameAndEventType(String name, String eventType);

}