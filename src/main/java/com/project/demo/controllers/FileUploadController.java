package com.project.demo.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.project.demo.entities.Hospital;
import com.project.demo.service.UploadService;


@RestController
@RequestMapping("/api/csv/")
public class FileUploadController {

    @Autowired
    UploadService uploadService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello World!";
    }

    @PostMapping("/upload-data")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                CsvToBean<Hospital> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Hospital.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                ArrayList<Hospital> hospitalData = (ArrayList<Hospital>) csvToBean.parse();
                uploadService.saveCSVData(hospitalData);

                return "Data Saved";

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "file-upload-status";
    }
    
}
