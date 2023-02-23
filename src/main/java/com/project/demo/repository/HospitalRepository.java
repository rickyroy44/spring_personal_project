package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findByCode(String code);
    void deleteByCode(String code);
}
