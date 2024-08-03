package com.atletasbr.olimpiadas.controller;

import com.atletasbr.olimpiadas.controller.dto.response.AthleteResponse;
import com.atletasbr.olimpiadas.controller.interfaces.IAthleteController;
import com.atletasbr.olimpiadas.service.athlete.IAthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/athletes/")
public class AthleteController implements IAthleteController {

    private final IAthleteService service;


    public AthleteController(IAthleteService service) {
        this.service = service;
    }



    @Override
    @GetMapping("{id}")
    public ResponseEntity<AthleteResponse> searchById(UUID id) {

        var response = service.findById(id);

        return ResponseEntity.ok(new AthleteResponse(response));

    }


    @Override
    @GetMapping("/name/{name}")
    public ResponseEntity<Set<AthleteResponse>> searchByName(String name) {

        return ResponseEntity.ok(service.findByName(name));

    }


    @Override
    @GetMapping
    public ResponseEntity<Set<AthleteResponse>> searchAll() {

        var response = service.findAll();

        return ResponseEntity.ok(response);

    }

}