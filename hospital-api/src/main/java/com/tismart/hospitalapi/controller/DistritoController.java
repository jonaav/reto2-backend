package com.tismart.hospitalapi.controller;

import com.tismart.hospitalapi.service.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distrito")
@CrossOrigin(origins = "http://localhost:4200")
public class DistritoController {

    @Autowired
    IDistritoService distritoService;

    @GetMapping
    public ResponseEntity getDistritos(){
        return ResponseEntity.ok(distritoService.findAll());
    }

}
