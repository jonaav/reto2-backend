package com.tismart.hospitalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalResponseDto {

    private Long idHospital;
    private String nombre;
    private int antiguedad;
    private double area;
    private String distrito;
    private String sede;
    private String gerente;
    private String condicion;
    private Timestamp fechaRegistro;
}
