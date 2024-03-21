package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.entity.Distrito;
import com.tismart.hospitalapi.repository.IDistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements IDistritoService{

    @Autowired
    IDistritoRepository distritoRepository;

    @Override
    public List<Distrito> findAll() {
        return (List<Distrito>) distritoRepository.findAll();
    }
}
