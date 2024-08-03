package com.atletasbr.olimpiadas.utils;

import com.atletasbr.olimpiadas.controller.dto.request.AthleteRequest;
import com.atletasbr.olimpiadas.controller.dto.response.AthleteResponse;
import com.atletasbr.olimpiadas.model.AthleteModel;

import java.time.LocalDate;
import java.time.Month;


public class AthleteData {

    public static AthleteModel createAthleteModel() {

        var athlete = new AthleteModel();
        athlete.setName("Rayssa Leal");
        athlete.setAge(16);
        athlete.setDateBirth(LocalDate.of(2008, Month.JANUARY, 4));
        athlete.setSex('F');
        athlete.setRegistrationNumber(1);
        athlete.setModality(ModalityData.createModalityModel());

        return athlete;

    }


    public static AthleteRequest createAthleteRequest(){

        return new AthleteRequest("Rayssa Leal", 16, LocalDate.of(2008, Month.JANUARY, 04), 'F', 1,"Skate", "Street Feminino");

    }


    public static AthleteResponse createAthleteResponse(){

        return new AthleteResponse("Rayssa Leal", 16, LocalDate.of(2008, Month.JANUARY, 04), 'F', 1, ModalityData.createModalityResponse());

    }

}