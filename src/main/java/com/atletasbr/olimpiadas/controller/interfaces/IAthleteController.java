package com.atletasbr.olimpiadas.controller.interfaces;

import com.atletasbr.olimpiadas.controller.dto.response.AthleteResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.UUID;


public interface IAthleteController {

    ResponseEntity<AthleteResponse> searchById(UUID id);

    ResponseEntity<Set<AthleteResponse>> searchByName(String name);

    ResponseEntity<Set<AthleteResponse>> searchAll();

}