package com.atletasbr.olimpiadas.service;

import com.atletasbr.olimpiadas.config.exception.handlers.DataAlreadyExistsException;
import com.atletasbr.olimpiadas.config.exception.handlers.DataNotFoundException;
import com.atletasbr.olimpiadas.model.ModalityModel;
import com.atletasbr.olimpiadas.repository.ModalityRepository;
import com.atletasbr.olimpiadas.service.modality.ModalityService;
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
class ModalityTest {

    @Mock
    ModalityRepository repository;

    @InjectMocks
    ModalityService service;



    //SAVE
    @Test
    @DisplayName("A modalidade deve ser registrada quando os dados passados forem corretos")
    void should_save_Modality_when_correct_data_passed() {

        when(repository.existsByEventType(any()))
                .thenReturn(false);
        when(repository.save(any(ModalityModel.class)))
                .thenReturn(ModalityData.createModalityModel());


        var response = service.save(ModalityData.createModality());


        assertEquals(Collections.singletonList(ModalityData.createModalityModel()), response);
        verify(repository, times(1)).existsByEventType(any());
        verify(repository, times(1)).save(any(ModalityModel.class));

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando o evento que corresponde a modalidade já estiver resgitrado")
    void throw_exception_when_Event_Already_Exists() {

        when(repository.existsByEventType(any()))
                .thenReturn(true);


        var exception = assertThrows(DataAlreadyExistsException.class, () -> {
            service.save(ModalityData.createModality());

        });

        verify(repository, times(1)).existsByEventType(any());
        assertEquals("Dado cadastrado já existe", exception.getMessage());

    }


    //FIND BY ID
    @Test
    @DisplayName("Uma modalidade deve ser retornado quando o seu id for passado corretamente")
    void find_modality_when_correct_id_passed(){

        when(repository.findById(any()))
                .thenReturn(Optional.of(ModalityData.createModalityModel()));


        service.findById(any());


        verify(repository, times(1)).findById(any());

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando a modalidade não estiver registrada")
    void throw_exception_when_modality_not_exists() {

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
    @DisplayName("Uma modalidade deve ser retornada quando o seu nome for passado corretamente")
    void find_modality_when_correct_name_passed(){

        when(repository.findByName(any()))
                .thenReturn(Collections.singletonList(ModalityData.createModalityModel()));


        service.findByName(any());


        verify(repository, times(1)).findByName(any());

    }


    @Test
    @DisplayName("Uma exceção deve ser lançada quando a modalidade não estiver registrada")
    void throw_exception_when_modality_name_not_exists(){

        when(repository.findByName(any()))
                .thenReturn(Collections.emptyList());


        var exception = assertThrows(DataNotFoundException.class, () -> {
            service.findByName(any());

        });

        verify(repository, times(1)).findByName(any());
        assertEquals("Dado(s) não encontrado", exception.getMessage());

    }


    //FIND ALL
    @Test
    @DisplayName("As modalidades e seus respectivos eventos devem ser retornados")
    void should_Return_All_Modality() {

        when(repository.findAll())
                .thenReturn(Collections.singletonList(ModalityData.createModalityModel()));

        var response = service.findAll();

        assertEquals(Collections.singleton(ModalityData.createModalityResponse()), response);
        verify(repository, times(1)).findAll();

    }

}