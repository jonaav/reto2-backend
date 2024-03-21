package com.tismart.hospitalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalRequestDto {

    private Long idDistrito;
    private Long idProvincia;
    private String nombre;
    private int antiguedad;
    private double area;
    private Long idSede;
    private Long idGerente;
    private Long idCondicion;
    private Date fechaRegistro;
}
