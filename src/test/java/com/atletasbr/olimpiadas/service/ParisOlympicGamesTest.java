package com.atletasbr.olimpiadas.service;

import com.atletasbr.olimpiadas.model.ParisOlympicGamesModel;
import com.atletasbr.olimpiadas.repository.ParisOlympicGamesRepository;
import com.atletasbr.olimpiadas.service.athlete.IAthleteService;
import com.atletasbr.olimpiadas.service.olympics.ParisOlympicGamesService;
import com.atletasbr.olimpiadas.utils.AthleteData;
import com.atletasbr.olimpiadas.utils.ParisOlympicGamesData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ParisOlympicGamesTest {

    @Mock
    IAthleteService athleteService;

    @Mock
    ParisOlympicGamesRepository repository;

    @InjectMocks
    ParisOlympicGamesService service;



    //SAVE
    @Test
    @DisplayName("O registro de participação do atleta deve ser registrado quando os dados passados forem corretos")
    void should_save_olimpic_game_when_correct_data_passed() {

        when(athleteService.save(any()))
                .thenReturn(AthleteData.createAthleteModel());
        when(repository.save(any(ParisOlympicGamesModel.class)))
                .thenReturn(ParisOlympicGamesData.createParisOlympicGamesModel());


        var response = service.save(ParisOlympicGamesData.createParisOlympicGamesRequest());


        assertEquals(ParisOlympicGamesData.createParisOlympicGamesModel(), response);
        verify(athleteService, times(1)).save(any());
        verify(repository, times(1)).save(any(ParisOlympicGamesModel.class));

    }

}