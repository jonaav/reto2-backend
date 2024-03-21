package com.tismart.hospitalapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuscarHospitalesPorResponseDto {


    private List<HospitalResponseDto> hospitales;
    private ResponseDto respuesta;
}
