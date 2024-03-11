package com.registerpatient.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HealthPolicyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_id")
	private int healthPolicyId;

	@Column(name = "policy_org")
	private String healthPolicyOrg;

	@Column(name = "policy_no")
	private String healthPolicyNo;

	@Column(name = "policy_cover_amount")
	private long healthPolicyCoverAmount;

	@Column(name = "policy_type")
	private String healthPolicyType;

	@Column(name = "policy_holder_name")
	private String policyHolderName;

	@Column(name = "policy_holder_dob")
	private Date policyHolderDOB;

	@Column(name = "policy_holder_adhaar_number")
	private String policyHolderAdhaarNo;

//	@OneToOne(mappedBy = "healthPolicyDetails")
//	private Patient patient;

	public HealthPolicyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthPolicyDetails(int healthPolicyId, String healthPolicyOrg, String healthPolicyNo,
			long healthPolicyCoverAmount, String healthPolicyType, String policyHolderName, Date policyHolderDOB,
			String policyHolderAdhaarNo) {
		super();
		this.healthPolicyId = healthPolicyId;
		this.healthPolicyOrg = healthPolicyOrg;
		this.healthPolicyNo = healthPolicyNo;
		this.healthPolicyCoverAmount = healthPolicyCoverAmount;
		this.healthPolicyType = healthPolicyType;
		this.policyHolderName = policyHolderName;
		this.policyHolderDOB = policyHolderDOB;
		this.policyHolderAdhaarNo = policyHolderAdhaarNo;
	}

	public int getHealthPolicyId() {
		return healthPolicyId;
	}

	public void setHealthPolicyId(int healthPolicyId) {
		this.healthPolicyId = healthPolicyId;
	}

	public String getHealthPolicyOrg() {
		return healthPolicyOrg;
	}

	public void setHealthPolicyOrg(String healthPolicyOrg) {
		this.healthPolicyOrg = healthPolicyOrg;
	}

	public String getHealthPolicyNo() {
		return healthPolicyNo;
	}

	public void setHealthPolicyNo(String healthPolicyNo) {
		this.healthPolicyNo = healthPolicyNo;
	}

	public long getHealthPolicyCoverAmount() {
		return healthPolicyCoverAmount;
	}

	public void setHealthPolicyCoverAmount(long healthPolicyCoverAmount) {
		this.healthPolicyCoverAmount = healthPolicyCoverAmount;
	}

	public String getHealthPolicyType() {
		return healthPolicyType;
	}

	public void setHealthPolicyType(String healthPolicyType) {
		this.healthPolicyType = healthPolicyType;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public Date getPolicyHolderDOB() {
		return policyHolderDOB;
	}

	public void setPolicyHolderDOB(Date policyHolderDOB) {
		this.policyHolderDOB = policyHolderDOB;
	}

	public String getPolicyHolderAdhaarNo() {
		return policyHolderAdhaarNo;
	}

	public void setPolicyHolderAdhaarNo(String policyHolderAdhaarNo) {
		this.policyHolderAdhaarNo = policyHolderAdhaarNo;
	}

	@Override
	public String toString() {
		return "HealthPolicyDetails [healthPolicyId=" + healthPolicyId + ", healthPolicyOrg=" + healthPolicyOrg
				+ ", healthPolicyNo=" + healthPolicyNo + ", healthPolicyCoverAmount=" + healthPolicyCoverAmount
				+ ", healthPolicyType=" + healthPolicyType + ", policyHolderName=" + policyHolderName
				+ ", policyHolderDOB=" + policyHolderDOB + ", policyHolderAdhaarNo=" + policyHolderAdhaarNo + "]";
	}

}
