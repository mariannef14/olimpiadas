package com.atletasbr.olimpiadas.controller.dto.response;

import com.atletasbr.olimpiadas.model.AthleteModel;

import java.time.LocalDate;


public record AthleteResponse(

        String name,

        int age,

        LocalDate dateOfBirth,

        char sex,

        Integer registrationNumber,

        ModalityEventResponse modality) {


    public AthleteResponse(AthleteModel model){

        this(model.getName(), model.getAge(), model.getDateBirth(), model.getSex(), model.getRegistrationNumber(),
                new ModalityEventResponse(model.getModality()));

    }
}