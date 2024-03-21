package com.tismart.hospitalapi.repository;

import com.tismart.hospitalapi.dto.HospitalResponseDto;
import com.tismart.hospitalapi.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IHospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByIdHospital(Long idHospital);
}
