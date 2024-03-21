package com.tismart.hospitalapi.dao;

import com.tismart.hospitalapi.dto.BuscarHospitalesPorResponseDto;
import com.tismart.hospitalapi.dto.HospitalRequestDto;
import com.tismart.hospitalapi.dto.ResponseDto;
import com.tismart.hospitalapi.entity.Hospital;

import java.util.List;

public interface IHospitalDao {

    public BuscarHospitalesPorResponseDto buscarHospitalesPor(HospitalRequestDto requestDto);
    public ResponseDto registrarHospital(HospitalRequestDto requestDto);
    public ResponseDto actualizarHospital(HospitalRequestDto requestDto, Long id);
    public ResponseDto eliminarHospital(Long id);
}
