package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.entity.Gerente;
import com.tismart.hospitalapi.repository.IGerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteServiceImpl implements IGerenteService{

    @Autowired
    IGerenteRepository gerenteRepository;

    @Override
    public List<Gerente> findAll() {
        return (List<Gerente>) gerenteRepository.findAll();
    }
}
