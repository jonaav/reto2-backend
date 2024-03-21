package com.tismart.hospitalapi.controller;

import com.tismart.hospitalapi.service.IGerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gerente")
@CrossOrigin(origins = "http://localhost:4200")
public class GerenteController {

    @Autowired
    IGerenteService gerenteService;

    @GetMapping
    public ResponseEntity getGerentes(){
        return ResponseEntity.ok(gerenteService.findAll());
    }
}
