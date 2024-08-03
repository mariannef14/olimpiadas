package com.atletasbr.olimpiadas.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record AthleteRequest(

        @NotBlank(message = "O nome do atleta deve ser inserido")
        String name,

        @NotNull(message = "A idade do atleta deve ser inserida")
        int age,

        @NotNull(message = "A data de nascimento do atleta deve ser inserida")
        LocalDate dateOfBirth,

        @NotNull(message = "O sexo do atleta deve ser inserido")
        char sex,

        @NotNull(message = "O número de registro do atleta deve ser inserido")
        Integer registrationNumber,

        @NotNull(message = "A modalidade do atleta deve ser inserida")
        String modality,

        @NotNull(message = "O evento que corresponde a modalidade escolhida deve ser inserido")
        String eventType) {}