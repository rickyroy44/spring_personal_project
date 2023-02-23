package com.project.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Hospital;
import com.project.demo.service.HospitalDataService;

@RestController
@RequestMapping("/api/data")
public class HospitalController {

    @Autowired
    HospitalDataService hospitalDataService;
    

    @GetMapping("/all")
    public List<Hospital> getAllHospitalData() {
        return hospitalDataService.getAllHospitalData();
    }

    @GetMapping("/record")
    public Hospital getHospitalDataByCode(@RequestParam("code") String code) {
        return hospitalDataService.getHospitalDataById(code);
    }

    @GetMapping("/delete")
    public String deleteHospitalRecordByCode(@RequestParam("code") String code) {
        hospitalDataService.deleteHospitalRecord(code);
        return "deleted";
    }
    
}
