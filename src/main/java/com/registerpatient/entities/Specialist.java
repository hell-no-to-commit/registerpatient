package com.registerpatient.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Specialist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "doctor_department")
	private String doctorDepartment;

	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialist(int doctorId, String doctorName, String doctorDepartment) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorDepartment = doctorDepartment;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorDepartment() {
		return doctorDepartment;
	}

	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}

	@Override
	public String toString() {
		return "Specialist [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorDepartment="
				+ doctorDepartment + "]";
	}

}
