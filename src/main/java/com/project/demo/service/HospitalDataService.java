package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.repository.HospitalRepository;

import jakarta.transaction.Transactional;

import com.project.demo.entities.Hospital;
import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class HospitalDataService {

    @Autowired
    HospitalRepository repository;

    public List<Hospital> getAllHospitalData() {
        List<Hospital> allData = new ArrayList<>();
        allData = repository.findAll();
        return allData;
    }

    public Hospital getHospitalDataById(String code) {
        Hospital data = repository.findByCode(code);
        return data;
    }

    public void deleteHospitalRecord(String code) {
        repository.deleteByCode(code);
    }
    
}
