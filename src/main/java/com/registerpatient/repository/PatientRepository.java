package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerpatient.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
