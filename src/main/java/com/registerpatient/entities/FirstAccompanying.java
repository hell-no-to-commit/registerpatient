package com.registerpatient.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FirstAccompanying {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "primary_accompanying_id")
	private int firstAccompanyingId;

	@Column(name = "primary_accompanying_name")
	private String firstAccompanyingName;

	@Column(name = "primary_accompanying_contact_no")
	private String firstAccompanyingContact;

	@Column(name = "primary_accompanying_adhaar_no")
	private String firstAccompanyingAdhaarNo;

	public FirstAccompanying() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FirstAccompanying(int firstAccompanyingId, String firstAccompanyingName, String firstAccompanyingContact,
			String firstAccompanyingAdhaarNo) {
		super();
		this.firstAccompanyingId = firstAccompanyingId;
		this.firstAccompanyingName = firstAccompanyingName;
		this.firstAccompanyingContact = firstAccompanyingContact;
		this.firstAccompanyingAdhaarNo = firstAccompanyingAdhaarNo;
	}

	public int getFirstAccompanyingId() {
		return firstAccompanyingId;
	}

	public void setFirstAccompanyingId(int firstAccompanyingId) {
		this.firstAccompanyingId = firstAccompanyingId;
	}

	public String getFirstAccompanyingName() {
		return firstAccompanyingName;
	}

	public void setFirstAccompanyingName(String firstAccompanyingName) {
		this.firstAccompanyingName = firstAccompanyingName;
	}

	public String getFirstAccompanyingContact() {
		return firstAccompanyingContact;
	}

	public void setFirstAccompanyingContact(String firstAccompanyingContact) {
		this.firstAccompanyingContact = firstAccompanyingContact;
	}

	public String getFirstAccompanyingAdhaarNo() {
		return firstAccompanyingAdhaarNo;
	}

	public void setFirstAccompanyingAdhaarNo(String firstAccompanyingAdhaarNo) {
		this.firstAccompanyingAdhaarNo = firstAccompanyingAdhaarNo;
	}

	@Override
	public String toString() {
		return "FirstAccompanying [firstAccompanyingId=" + firstAccompanyingId + ", firstAccompanyingName="
				+ firstAccompanyingName + ", firstAccompanyingContact=" + firstAccompanyingContact
				+ ", firstAccompanyingAdhaarNo=" + firstAccompanyingAdhaarNo + "]";
	}

}
