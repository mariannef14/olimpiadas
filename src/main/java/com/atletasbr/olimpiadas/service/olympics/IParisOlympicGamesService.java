package com.atletasbr.olimpiadas.service.olympics;

import com.atletasbr.olimpiadas.controller.dto.request.OlympicGamesRequest;
import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;

import java.util.List;
import java.util.UUID;


public interface IParisOlympicGamesService {

    ParisOlympicGamesModel save(OlympicGamesRequest request);

    ParisOlympicGamesModel findById(UUID id);

    List<ParisOlympicGamesModel> findAll(String athleteName, String modality, String eventType);

}