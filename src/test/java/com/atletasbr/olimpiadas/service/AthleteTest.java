package com.atletasbr.olimpiadas.service;

import com.atletasbr.olimpiadas.config.exception.handlers.DataAlreadyExistsException;
import com.atletasbr.olimpiadas.config.exception.handlers.DataNotFoundException;
import com.atletasbr.olimpiadas.model.AthleteModel;
import com.atletasbr.olimpiadas.repository.AthleteRepository;
import com.atletasbr.olimpiadas.service.athlete.AtheteService;
import com.atletasbr.olimpiadas.service.modality.ModalityService;
import com.atletasbr.olimpiadas.utils.AthleteData;
import com.atletasbr.olimpiadas.utils.ModalityData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AthleteTest {

    @Mock
    AthleteRepository repository;

    @Mock
    ModalityService modalityService;

    @InjectMocks
    AtheteService service;



    //SAVE
    @Test
    @DisplayName("O atleta deve ser registrado quando os dados passados forem corretos")
    void should_save_athlete_when_correct_data_passed() {

        when(modalityService.findByNameAndEventType(any(), any()))
                .thenReturn(ModalityData.createModalityModel());
        when(repository.save(any(AthleteModel.class)))
                .thenReturn(AthleteData.createAthleteModel());
        when(repository.existsByRegistrationNumber(any()))
                .thenReturn(false);


        var response = service.save(AthleteData.createAthleteRequest());


        assertEquals(AthleteData.createAthleteModel(), response);
        verify(modalityService, times(1)).findByNameAndEventType(any(), any());
        verify(repository, times(1)).existsByRegistrationNumber(any());
        verify(repository, times(1)).save(any(AthleteModel.class));

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando o atleta já estiver resgitrado")
    void throw_exception_when_athlete_already_exists() {

        when(repository.existsByRegistrationNumber(any()))
                .thenReturn(true);


        var exception = assertThrows(DataAlreadyExistsException.class, () -> {
            service.save(AthleteData.createAthleteRequest());

        });

        verify(repository, times(1)).existsByRegistrationNumber(any());
        assertEquals("Dado cadastrado já existe", exception.getMessage());

    }


    //FIND BY ID
    @Test
    @DisplayName("Um atleta deve ser retornado quando o seu id for passado corretamente")
    void find_athlete_when_correct_id_passed(){

        when(repository.findById(any()))
                .thenReturn(Optional.of(AthleteData.createAthleteModel()));


        service.findById(any());


        verify(repository, times(1)).findById(any());

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando o atleta não estiver registrado")
    void throw_exception_when_athlete_not_exists() {

        when(repository.findById(any()))
                .thenReturn(Optional.empty());


        var exception = assertThrows(DataNotFoundException.class, () -> {
            service.findById(any());

        });

        verify(repository, times(1)).findById(any());
        assertEquals("Dado(s) não encontrado", exception.getMessage());

    }


    //FIND BY NAME
    @Test
    @DisplayName("Os atletas registrados devem ser retornados")
    void find_all_athlete_when_correct_name_passed() {

        when(repository.findByName(any()))
                .thenReturn(Collections.singleton(AthleteData.createAthleteModel()));

        var response = service.findByName(any());

        assertEquals(Collections.singleton(AthleteData.createAthleteResponse()), response);
        verify(repository, times(1)).findByName(any());

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando o atleta não estiver registrado")
    void throw_exception_when_athlete_name_not_exists() {

        when(repository.findByName(any()))
                .thenReturn(Collections.emptySet());


        var exception = assertThrows(DataNotFoundException.class, () -> {
            service.findByName(any());

        });

        verify(repository, times(1)).findByName(any());
        assertEquals("Dado(s) não encontrado", exception.getMessage());

    }


    //FIND ALL
    @Test
    @DisplayName("Os atletas registrados devem ser retornados")
    void should_return_all_athletes() {

        when(repository.findAll())
                .thenReturn(Collections.singletonList(AthleteData.createAthleteModel()));

        var response = service.findAll();

        assertEquals(Collections.singleton(AthleteData.createAthleteResponse()), response);
        verify(repository, times(1)).findAll();

    }


}
