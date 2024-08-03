package com.atletasbr.olimpiadas.utils;

import com.atletasbr.olimpiadas.controller.dto.request.ModalityRequest;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventResponse;
import com.atletasbr.olimpiadas.model.ModalityModel;
import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;

import java.util.Collections;


public class ModalityData {

    public static ModalityModel createModalityModel(){

        var modality = new ModalityModel();
        modality.setName("Skate");
        modality.setEventType(EventTypeEnum.STREET_FEMININO);

        return modality;

    }


    public static ModalityRequest createModality(){

        return new ModalityRequest("Skate", Collections.singletonList(EventTypeEnum.STREET_FEMININO));

    }


    public static ModalityEventResponse createModalityResponse(){

        return new ModalityEventResponse("Skate","STREET_FEMININO");

    }

}