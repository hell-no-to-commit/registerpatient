package com.registerpatient.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private int policyId;

	@Column(name = "policy_number")
	private String policyNumber;

	@Column(name = "organization")
	private String organization;

	@Column(name = "policy_type")
	private String policyType;

	@Column(name = "tenure")
	private String tenure;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(int policyId, String policyNumber, String organization, String policyType, String tenure,
			Date startDate, Date endDate) {
		super();
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.organization = organization;
		this.policyType = policyType;
		this.tenure = tenure;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyNumber=" + policyNumber + ", organization=" + organization
				+ ", policyType=" + policyType + ", tenure=" + tenure + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
