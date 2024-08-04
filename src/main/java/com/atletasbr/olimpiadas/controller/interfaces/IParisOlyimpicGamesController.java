package com.atletasbr.olimpiadas.controller.interfaces;

import com.atletasbr.olimpiadas.controller.dto.request.OlympicGamesRequest;
import com.atletasbr.olimpiadas.controller.dto.response.OlympicGamesResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IParisOlyimpicGamesController {

    ResponseEntity<OlympicGamesResponse> register(OlympicGamesRequest request);

    ResponseEntity<List<OlympicGamesResponse>> searchAll(String athleteName, String modality, String eventType);

}