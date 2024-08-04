package com.atletasbr.olimpiadas.controller;


import com.atletasbr.olimpiadas.controller.dto.request.OlympicGamesRequest;
import com.atletasbr.olimpiadas.controller.dto.response.OlympicGamesResponse;
import com.atletasbr.olimpiadas.controller.interfaces.IParisOlyimpicGamesController;
import com.atletasbr.olimpiadas.service.olympics.IParisOlympicGamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/olympic-games/")
public class ParisOlyimpicGamesController implements IParisOlyimpicGamesController {

    private final IParisOlympicGamesService service;


    public ParisOlyimpicGamesController(IParisOlympicGamesService service) {
        this.service = service;
    }



    @Override
    @PostMapping
    public ResponseEntity<OlympicGamesResponse> register(@RequestBody OlympicGamesRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(new OlympicGamesResponse(service.save(request)));

    }


    @Override
    @GetMapping
    public ResponseEntity<List<OlympicGamesResponse>> searchAll(@RequestParam(required = false) String athleteName,
                                                                @RequestParam(required = false) String modality,
                                                                @RequestParam(required = false) String eventType) {

        return ResponseEntity.ok(service.findAll(athleteName, modality, eventType).stream().map(OlympicGamesResponse::new).toList());
    }

}