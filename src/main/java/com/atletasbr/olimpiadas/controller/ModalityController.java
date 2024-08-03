package com.atletasbr.olimpiadas.controller;

import com.atletasbr.olimpiadas.controller.dto.request.ModalityRequest;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventResponse;
import com.atletasbr.olimpiadas.controller.dto.response.ModalityEventsResponse;
import com.atletasbr.olimpiadas.controller.interfaces.IModalityController;
import com.atletasbr.olimpiadas.service.modality.IModalityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/modalities/")
public class ModalityController implements IModalityController {

    private final IModalityService service;


    public ModalityController(IModalityService service) {
        this.service = service;
    }


    @Override
    @PostMapping
    public ResponseEntity<ModalityEventsResponse> register(@RequestBody ModalityRequest request) {

        var modality = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ModalityEventsResponse(modality));

    }


    @Override
    @GetMapping("{id}")
    public ResponseEntity<ModalityEventResponse> searchById(@PathVariable UUID id) {

        return ResponseEntity.ok(new ModalityEventResponse(service.findById(id)));
    }


    @Override
    @GetMapping("name/{name}")
    public ResponseEntity<ModalityEventsResponse> searchByName(@PathVariable String name) {

        return ResponseEntity.ok(new ModalityEventsResponse(service.findByName(name.toUpperCase())));

    }


    @Override
    @GetMapping
    public ResponseEntity<Set<ModalityEventResponse>> searchAll() {

        return ResponseEntity.ok(service.findAll());

    }

}