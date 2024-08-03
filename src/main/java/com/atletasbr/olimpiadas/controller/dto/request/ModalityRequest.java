package com.atletasbr.olimpiadas.controller.dto.request;

import com.atletasbr.olimpiadas.model.enums.EventTypeEnum;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


public record ModalityRequest(

    @NotBlank(message = "O nome da modalidade deve ser inserido")
    String name,

    @NotBlank(message = "Os eventos correspondentes a modalidade devem ser inseridos")
    List<EventTypeEnum> eventType) {}
