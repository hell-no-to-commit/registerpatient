package com.registerpatient.entities;



import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int patientId;

	@NotBlank(message = "Name field is required!!")
	@Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!")
	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "patient_dob")
	private Date patientDOB;

	 @Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!")
	@Column(name = "patient_adhaar_no")
	private String patientAdhaar;

	@Column(name = "patient_contact_no")
	private long patientContact;

	@Column(name = "patient_emergency_contact_no")
	private long patientEmergencyContact;

	@Column(name = "patient_address")
	private String patientAddress;

	@Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!")
	@Column(name = "patient_illness")
	private String patientIllness;

	@Column(name = "patient_preferred_doc_gender")
	private String patientpreferredDoctorGender;

	@Size(min = 4, max = 20, message = "minimum 4 and maximum 30 characters are allowed!!")
	@Column(name = "patient_symptoms")
	private String patientSymptoms;

	@Column(name = "patient_health_policy_org")
	private String patientHealthPolicyOrg;

	@Column(name = "patient_health_policy_no")
	private String patientHealthPolicyNo;

	@OneToOne(cascade = CascadeType.ALL)
	private FirstAccompanying patient1stRelative;

	@OneToOne(cascade = CascadeType.ALL)
	private SecondAccompanying patient2ndRelative;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientName, Date patientDOB, String patientAddress, String patientAdhaar,
			long patientContact, long patientEmergencyContact, String patientIllness, String patientSymptoms,
			String patientHealthPolicyOrg, String patientHealthPolicyNo, String patientpreferredDoctorGender,
			FirstAccompanying patient1stRelative, SecondAccompanying patient2ndRelative) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientDOB = patientDOB;
		this.patientAddress = patientAddress;
		this.patientAdhaar = patientAdhaar;
		this.patientContact = patientContact;
		this.patientEmergencyContact = patientEmergencyContact;
		this.patientIllness = patientIllness;
		this.patientSymptoms = patientSymptoms;
		this.patientHealthPolicyOrg = patientHealthPolicyOrg;
		this.patientHealthPolicyNo = patientHealthPolicyNo;
		this.patientpreferredDoctorGender = patientpreferredDoctorGender;
		this.patient1stRelative = patient1stRelative;
		this.patient2ndRelative = patient2ndRelative;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientAdhaar() {
		return patientAdhaar;
	}

	public void setPatientAdhaar(String patientAdhaar) {
		this.patientAdhaar = patientAdhaar;
	}

	public long getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(long patientContact) {
		this.patientContact = patientContact;
	}

	public long getPatientEmergencyContact() {
		return patientEmergencyContact;
	}

	public void setPatientEmergencyContact(long patientEmergencyContact) {
		this.patientEmergencyContact = patientEmergencyContact;
	}

	public String getPatientIllness() {
		return patientIllness;
	}

	public void setPatientIllness(String patientIllness) {
		this.patientIllness = patientIllness;
	}

	public String getPatientSymptoms() {
		return patientSymptoms;
	}

	public void setPatientSymptoms(String patientSymptoms) {
		this.patientSymptoms = patientSymptoms;
	}

	public String getPatientHealthPolicyOrg() {
		return patientHealthPolicyOrg;
	}

	public void setPatientHealthPolicyOrg(String patientHealthPolicyOrg) {
		this.patientHealthPolicyOrg = patientHealthPolicyOrg;
	}

	public String getPatientHealthPolicyNo() {
		return patientHealthPolicyNo;
	}

	public void setPatientHealthPolicyNo(String patientHealthPolicyNo) {
		this.patientHealthPolicyNo = patientHealthPolicyNo;
	}

	public String getPatientpreferredDoctorGender() {
		return patientpreferredDoctorGender;
	}

	public void setPatientpreferredDoctorGender(String patientpreferredDoctorGender) {
		this.patientpreferredDoctorGender = patientpreferredDoctorGender;
	}

	public FirstAccompanying getPatient1stRelative() {
		return patient1stRelative;
	}

	public void setPatient1stRelative(FirstAccompanying patient1stRelative) {
		this.patient1stRelative = patient1stRelative;
	}

	public SecondAccompanying getPatient2ndRelative() {
		return patient2ndRelative;
	}

	public void setPatient2ndRelative(SecondAccompanying patient2ndRelative) {
		this.patient2ndRelative = patient2ndRelative;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientDOB=" + patientDOB
				+ ", patientAddress=" + patientAddress + ", patientAdhaar=" + patientAdhaar + ", patientContact="
				+ patientContact + ", patientEmergencyContact=" + patientEmergencyContact + ", patientIllness="
				+ patientIllness + ", patientSymptoms=" + patientSymptoms + ", patientHealthPolicyOrg="
				+ patientHealthPolicyOrg + ", patientHealthPolicyNo=" + patientHealthPolicyNo
				+ ", patientpreferredDoctorGender=" + patientpreferredDoctorGender + ", patient1stRelative="
				+ patient1stRelative + ", patient2ndRelative=" + patient2ndRelative + "]";
	}

}
