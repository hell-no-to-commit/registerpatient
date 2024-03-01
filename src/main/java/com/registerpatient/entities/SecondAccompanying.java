package com.registerpatient.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SecondAccompanying {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "secondary_accompanying_id")
	private int secondAccompanyingId;
	
	@Column(name = "secondary_accompanying_name")
	private String secondAccompanyingName;
	
	@Column(name = "secondary_accompanying_contact_no")
	private String secondAccompanyingContact;
	
	@Column(name = "secondary_accompanying_adhaar_no")
	private String secondAccompanyingAdhaarNo;

	public SecondAccompanying() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecondAccompanying(int secondAccompanyingId, String secondAccompanyingName, String secondAccompanyingContact,
			String secondAccompanyingAdhaarNo) {
		super();
		this.secondAccompanyingId = secondAccompanyingId;
		this.secondAccompanyingName = secondAccompanyingName;
		this.secondAccompanyingContact = secondAccompanyingContact;
		this.secondAccompanyingAdhaarNo = secondAccompanyingAdhaarNo;
	}

	public int getSecondAccompanyingId() {
		return secondAccompanyingId;
	}

	public void setSecondAccompanyingId(int secondAccompanyingId) {
		this.secondAccompanyingId = secondAccompanyingId;
	}

	public String getSecondAccompanyingName() {
		return secondAccompanyingName;
	}

	public void setSecondAccompanyingName(String secondAccompanyingName) {
		this.secondAccompanyingName = secondAccompanyingName;
	}

	public String getSecondAccompanyingContact() {
		return secondAccompanyingContact;
	}

	public void setSecondAccompanyingContact(String secondAccompanyingContact) {
		this.secondAccompanyingContact = secondAccompanyingContact;
	}

	public String getSecondAccompanyingAdhaarNo() {
		return secondAccompanyingAdhaarNo;
	}

	public void setSecondAccompanyingAdhaarNo(String secondAccompanyingAdhaarNo) {
		this.secondAccompanyingAdhaarNo = secondAccompanyingAdhaarNo;
	}

	@Override
	public String toString() {
		return "SecondAccompanying [secondAccompanyingId=" + secondAccompanyingId + ", secondAccompanyingName="
				+ secondAccompanyingName + ", secondAccompanyingContact=" + secondAccompanyingContact
				+ ", secondAccompanyingAdhaarNo=" + secondAccompanyingAdhaarNo + "]";
	}

	
}
