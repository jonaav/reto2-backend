package com.tismart.hospitalapi.controller;

import com.tismart.hospitalapi.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sede")
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {

    @Autowired
    ISedeService sedeService;

    @GetMapping
    public ResponseEntity getSedes(){
        return ResponseEntity.ok(sedeService.findAll());
    }
}
