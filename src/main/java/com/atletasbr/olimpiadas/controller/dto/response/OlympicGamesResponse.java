package com.atletasbr.olimpiadas.controller.dto.response;

import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;


public record OlympicGamesResponse(

        AthleteResponse athlete,

        int position) {


    public OlympicGamesResponse(ParisOlympicGamesModel model){

        this(new AthleteResponse(model.getAthlete()), model.getPosition());

    }

}