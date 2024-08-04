package com.atletasbr.olimpiadas.controller.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record OlympicGamesRequest(

        @NotNull(message = "Os dados do atleta devem ser inseridos")
        @Valid
        AthleteRequest athlete,

        @NotNull(message = "A data em que o atleta fez a sua participação deve ser inserida")
        LocalDate dateParticipation,

        @NotNull(message = "A posição do atleta nos jogos da sua modalidade deve ser inserida")
        int position) {}