package com.tismart.hospitalapi.service;

import com.tismart.hospitalapi.entity.Condicion;
import com.tismart.hospitalapi.entity.Sede;
import com.tismart.hospitalapi.repository.ICondicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionServiceImpl implements ICondicionService{

    @Autowired
    ICondicionRepository condicionRepository;
    @Override
    public List<Condicion> findAll() {
        return (List<Condicion>) condicionRepository.findAll();
    }
}
