package com.atletasbr.olimpiadas.service.athlete;

import com.atletasbr.olimpiadas.controller.dto.request.AthleteRequest;
import com.atletasbr.olimpiadas.controller.dto.response.AthleteResponse;
import com.atletasbr.olimpiadas.model.AthleteModel;

import java.util.Set;
import java.util.UUID;


public interface IAthleteService {

    AthleteModel save(AthleteRequest request);

    AthleteModel findById(UUID id);

    Set<AthleteResponse> findByName(String name);

    Set<AthleteResponse> findAll();

}