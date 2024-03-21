package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.dao.IHospitalDao;
import com.tismart.hospitalapi.dto.BuscarHospitalesPorResponseDto;
import com.tismart.hospitalapi.dto.HospitalRequestDto;
import com.tismart.hospitalapi.dto.HospitalResponseDto;
import com.tismart.hospitalapi.dto.ResponseDto;
import com.tismart.hospitalapi.entity.Hospital;
import com.tismart.hospitalapi.repository.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl implements HospitalService {


    @Autowired
    IHospitalRepository hospitalRepository;
    @Autowired
    IHospitalDao hospitalDao;

    @Override
    public List<HospitalResponseDto> findAll() {
        List<Hospital> hospitales = (List<Hospital>) hospitalRepository.findAll();
        List<HospitalResponseDto> responseDtoList = hospitales.stream().map(h ->
                HospitalResponseDto.builder()
                        .idHospital(h.getIdHospital())
                        .area(h.getArea())
                        .antiguedad(h.getAntiguedad())
                        .nombre(h.getNombre())
                        .fechaRegistro(h.getFechaRegistro())
                        .build()).collect(Collectors.toList());
        return responseDtoList;
    }

    @Override
    public HospitalResponseDto findByIdHospital(Long idHospital) {
        Optional<Hospital> hospitalBD = hospitalRepository.findByIdHospital(idHospital);
        HospitalResponseDto responseDto = HospitalResponseDto.builder()
                .idHospital(hospitalBD.get().getIdHospital())
                .nombre(hospitalBD.get().getNombre())
                .antiguedad(hospitalBD.get().getAntiguedad())
                .area(hospitalBD.get().getArea())
                .distrito(hospitalBD.get().getIdDistrito().toString())
                .sede(hospitalBD.get().getIdSede().toString())
                .gerente(hospitalBD.get().getIdGerente().toString())
                .condicion(hospitalBD.get().getIdCondicion().toString())
                .fechaRegistro(hospitalBD.get().getFechaRegistro())
                .build();

        return responseDto;
    }

    @Override
    public BuscarHospitalesPorResponseDto searchByParams(HospitalRequestDto requestDto) {
        BuscarHospitalesPorResponseDto response = hospitalDao.buscarHospitalesPor(requestDto);
        return response;
    }

    @Override
    public ResponseDto create(HospitalRequestDto requestDto) {
        ResponseDto response = hospitalDao.registrarHospital(requestDto);
        return response;
    }

    @Override
    public ResponseDto update(HospitalRequestDto requestDto, Long id) {
        ResponseDto response = hospitalDao.actualizarHospital(requestDto, id);
        return response;
    }

    @Override
    public ResponseDto delete(Long id) {
        ResponseDto response = hospitalDao.eliminarHospital(id);
        return response;
    }
}
