package com.registerpatient.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TreatmentHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Patient patient;
	private String treatmentInformation;
	private LocalDateTime timestamp;

	public TreatmentHistory() {
		super();
	}

	public TreatmentHistory(Patient patient, String treatmentInformation, LocalDateTime timestamp) {
		super();
		this.patient = patient;
		this.treatmentInformation = treatmentInformation;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTreatmentInformation() {
		return treatmentInformation;
	}

	public void setTreatmentInformation(String treatmentInformation) {
		this.treatmentInformation = treatmentInformation;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TreatmentHistory [id=" + id + ", patient=" + patient + ", treatmentInformation=" + treatmentInformation
				+ ", timestamp=" + timestamp + "]";
	}

}
