package com.atletasbr.olimpiadas.controller.dto.response;

import com.atletasbr.olimpiadas.model.ModalityModel;


public record ModalityEventResponse(

        String name,

        String eventsType) {


    public ModalityEventResponse(ModalityModel model) {

        this(model.getName(),  model.getEventType().name());

    }
}
