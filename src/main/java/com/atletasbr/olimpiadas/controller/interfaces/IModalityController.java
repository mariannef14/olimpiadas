package com.atletasbr.olimpiadas.controller.interfaces;

import com.atletasbr.olimpiadas.controller.dto.request.ModalityRequest;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventResponse;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventsResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.UUID;


public interface IModalityController {

    ResponseEntity<ModalityEventsResponse> register(ModalityRequest request);

    ResponseEntity<ModalityEventResponse> searchById(UUID id);

    ResponseEntity<ModalityEventsResponse> searchByName(String name);

    ResponseEntity<Set<ModalityEventResponse>> searchAll();

}