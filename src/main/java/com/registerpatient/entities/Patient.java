package com.registerpatient.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

//	@Column(name = "patient_health_policy_org")
//	private String patientHealthPolicyOrg;
//
//	@Column(name = "patient_health_policy_no")
//	private String patientHealthPolicyNo;

	@Column(name = "patient_guardian_name")
	private String patientGuardianName;

	@Column(name = "patient_guardian_contact_no")
	private String patientGuardianContactNo;

	@Column(name = "patient_guardian_relationship")
	private String patientGuardianRelationship;

	@OneToOne(cascade = CascadeType.ALL)
	private FirstAccompanying patient1stRelative;

	@OneToOne(cascade = CascadeType.ALL)
	private SecondAccompanying patient2ndRelative;

	@OneToOne(cascade = CascadeType.ALL)
	private Policy policyDetails;

	public Patient(int patientId,
			@NotBlank(message = "Name field is required!!") @Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!") String patientName,
			Date patientDOB,
			@Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!") String patientAdhaar,
			long patientContact, long patientEmergencyContact, String patientAddress,
			@Size(min = 4, max = 20, message = "minimum 4 and maximum 20 characters are allowed!!") String patientIllness,
			String patientpreferredDoctorGender,
			@Size(min = 4, max = 20, message = "minimum 4 and maximum 30 characters are allowed!!") String patientSymptoms,
			String patientGuardianName, String patientGuardianContactNo, String patientGuardianRelationship,
			FirstAccompanying patient1stRelative, SecondAccompanying patient2ndRelative, Policy policyDetails) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientDOB = patientDOB;
		this.patientAdhaar = patientAdhaar;
		this.patientContact = patientContact;
		this.patientEmergencyContact = patientEmergencyContact;
		this.patientAddress = patientAddress;
		this.patientIllness = patientIllness;
		this.patientpreferredDoctorGender = patientpreferredDoctorGender;
		this.patientSymptoms = patientSymptoms;
		this.patientGuardianName = patientGuardianName;
		this.patientGuardianContactNo = patientGuardianContactNo;
		this.patientGuardianRelationship = patientGuardianRelationship;
		this.patient1stRelative = patient1stRelative;
		this.patient2ndRelative = patient2ndRelative;
		this.policyDetails = policyDetails;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
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

	public Policy getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(Policy policyDetails) {
		this.policyDetails = policyDetails;
	}

	public String getPatientGuardianName() {
		return patientGuardianName;
	}

	public void setPatientGuardianName(String patientGuardianName) {
		this.patientGuardianName = patientGuardianName;
	}

	public String getPatientGuardianContactNo() {
		return patientGuardianContactNo;
	}

	public void setPatientGuardianContactNo(String patientGuardianContactNo) {
		this.patientGuardianContactNo = patientGuardianContactNo;
	}

	public String getPatientGuardianRelationship() {
		return patientGuardianRelationship;
	}

	public void setPatientGuardianRelationship(String patientGuardianRelationship) {
		this.patientGuardianRelationship = patientGuardianRelationship;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientDOB=" + patientDOB
				+ ", patientAdhaar=" + patientAdhaar + ", patientContact=" + patientContact
				+ ", patientEmergencyContact=" + patientEmergencyContact + ", patientAddress=" + patientAddress
				+ ", patientIllness=" + patientIllness + ", patientpreferredDoctorGender="
				+ patientpreferredDoctorGender + ", patientSymptoms=" + patientSymptoms + ", patientGuardianName="
				+ patientGuardianName + ", patientGuardianContactNo=" + patientGuardianContactNo
				+ ", patientGuardianRelationship=" + patientGuardianRelationship + ", patient1stRelative="
				+ patient1stRelative + ", patient2ndRelative=" + patient2ndRelative + ", policyDetails=" + policyDetails
				+ "]";
	}

}
