package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerpatient.entities.TreatmentHistory;

public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, Long> {

}
