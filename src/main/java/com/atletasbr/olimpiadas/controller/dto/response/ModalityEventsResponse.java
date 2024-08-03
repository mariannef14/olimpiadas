package com.atletasbr.olimpiadas.controller.dto.response;

import com.atletasbr.olimpiadas.model.ModalityModel;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public record ModalityEventsResponse(

        String name,

        Set<String> eventsType) {


    public ModalityEventsResponse(List<ModalityModel> model) {

        this(model.get(0).getName(),  model.stream()
                .map(m -> m.getEventType().name())
                .collect(Collectors.toSet()));

    }

}
