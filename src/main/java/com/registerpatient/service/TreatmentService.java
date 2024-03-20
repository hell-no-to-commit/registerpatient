package com.registerpatient.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registerpatient.entities.Patient;
import com.registerpatient.entities.TreatmentHistory;
import com.registerpatient.repository.PatientRepository;
import com.registerpatient.repository.TreatmentHistoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TreatmentService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private TreatmentHistoryRepository treatmentHistoryRepository;
	
	//TreatmentHistory save(TreatmentHistory treatmentHistory);

	public void saveTreatmentHistory(Integer patientId, String treatmentInformation) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new EntityNotFoundException("Patient not found"));
		TreatmentHistory history = new TreatmentHistory();
		history.setPatient(patient);
		history.setTreatmentInformation(treatmentInformation);
		history.setTimestamp(LocalDateTime.now());
		treatmentHistoryRepository.save(history);
	}
}
