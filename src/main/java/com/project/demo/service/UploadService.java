package com.project.demo.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.project.demo.entities.Hospital;
import com.project.demo.repository.HospitalRepository;

@Service
public class UploadService {

    @Autowired
    HospitalRepository repository;


    public void saveCSVData(List<Hospital> hospitalData) {
        repository.saveAll(hospitalData);
    }
    
}
