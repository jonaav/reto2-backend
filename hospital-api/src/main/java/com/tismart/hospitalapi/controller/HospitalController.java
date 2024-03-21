package com.tismart.hospitalapi.controller;

import com.tismart.hospitalapi.dto.BuscarHospitalesPorResponseDto;
import com.tismart.hospitalapi.dto.HospitalRequestDto;
import com.tismart.hospitalapi.dto.HospitalResponseDto;
import com.tismart.hospitalapi.dto.ResponseDto;
import com.tismart.hospitalapi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/hospital")
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping()
    public ResponseEntity getHospitales(){
        List<HospitalResponseDto> hospitales = hospitalService.findAll();
        return ResponseEntity.ok(hospitales);
    }
    @GetMapping("/{id}")
    public ResponseEntity getHospitalById(@PathVariable("id") Long id){
        HospitalResponseDto hospital = hospitalService.findByIdHospital(id);
        return ResponseEntity.ok(hospital);
    }
    @GetMapping("/params")
    public ResponseEntity SearchByParams(@RequestParam(required = false) String nombre,
                                         @RequestParam(required = false) Long distrito,
                                         @RequestParam(required = false) Long provincia,
                                         @RequestParam(required = false) Long sede,
                                         @RequestParam(required = false) Long gerente,
                                         @RequestParam(required = false) Long condicion){
        HospitalRequestDto request = HospitalRequestDto.builder()
                .nombre(nombre!= null?nombre:"-")
                .idDistrito(distrito!= null?distrito:0)
                .idProvincia(provincia!= null?provincia:0)
                .idGerente(gerente!= null?gerente:0)
                .idSede(sede!= null?sede:0)
                .idCondicion(condicion!= null?condicion:0)
                .build();
        BuscarHospitalesPorResponseDto hospitales = hospitalService.searchByParams(request);
        return ResponseEntity.ok(hospitales);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody HospitalRequestDto request){
        ResponseDto response = hospitalService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody HospitalRequestDto request, @RequestParam Long id){
        ResponseDto response = hospitalService.update(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestParam Long id){
        ResponseDto response = hospitalService.delete(id);
        return ResponseEntity.ok(response);
    }
}
