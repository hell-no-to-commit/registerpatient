package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registerpatient.entities.HealthPolicyDetails;

@Repository
public interface HealthPolicyRepository extends JpaRepository<HealthPolicyDetails, Integer> {
//
//	@Query("SELECT DISTINCT h.healthPolicyOrg FROM HealthPolicyDetails h")
//    List<String> findDistinctData();
}
