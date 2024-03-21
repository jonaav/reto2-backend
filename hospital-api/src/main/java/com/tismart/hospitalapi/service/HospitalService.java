package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.dto.BuscarHospitalesPorResponseDto;
import com.tismart.hospitalapi.dto.HospitalRequestDto;
import com.tismart.hospitalapi.dto.HospitalResponseDto;
import com.tismart.hospitalapi.dto.ResponseDto;

import java.util.List;

public interface HospitalService {

    public List<HospitalResponseDto> findAll();
    public HospitalResponseDto findByIdHospital(Long idHospital);
    public BuscarHospitalesPorResponseDto searchByParams(HospitalRequestDto requestDto);
    public ResponseDto create(HospitalRequestDto requestDto);
    public ResponseDto update(HospitalRequestDto request, Long id);
    public ResponseDto delete(Long id);
}
