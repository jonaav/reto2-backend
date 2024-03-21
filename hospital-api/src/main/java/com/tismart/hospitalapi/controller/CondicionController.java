package com.tismart.hospitalapi.controller;

import com.tismart.hospitalapi.service.ICondicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/condicion")
@CrossOrigin(origins = "http://localhost:4200")
public class CondicionController {

    @Autowired
    ICondicionService condicionService;

    @GetMapping
    public ResponseEntity getCondiciones(){
        return ResponseEntity.ok(condicionService.findAll());
    }
}
