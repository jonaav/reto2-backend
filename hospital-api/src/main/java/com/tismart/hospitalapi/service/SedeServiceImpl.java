package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.entity.Sede;
import com.tismart.hospitalapi.repository.ISedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService{

    @Autowired
    ISedeRepository sedeRepository;
    @Override
    public List<Sede> findAll() {
        return (List<Sede>) sedeRepository.findAll();
    }
}
