package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerpatient.entities.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
