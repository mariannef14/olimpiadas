package com.atletasbr.olimpiadas.utils;

import com.atletasbr.olimpiadas.controller.dto.request.OlympicGamesRequest;
import com.atletasbr.olimpiadas.controller.dto.response.OlympicGamesResponse;
import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;

import java.time.LocalDate;
import java.time.Month;

public class ParisOlympicGamesData {


    public static ParisOlympicGamesModel createParisOlympicGamesModel() {

        var olympics = new ParisOlympicGamesModel();
        olympics.setAthlete(AthleteData.createAthleteModel());
        olympics.setModality(ModalityData.createModalityModel());
        olympics.setPosition(3);

        return olympics;

    }


    public static OlympicGamesRequest createParisOlympicGamesRequest(){

        return new OlympicGamesRequest(AthleteData.createAthleteRequest(), LocalDate.of(2024, Month.JULY, 28), 3);

    }


    public static OlympicGamesResponse createParisOlympicGamesResponse(){

        return new OlympicGamesResponse(AthleteData.createAthleteResponse(), 3);

    }

}