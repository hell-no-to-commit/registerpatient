package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registerpatient.entities.RoomCapacity;


public interface CapacityRepository extends JpaRepository<RoomCapacity, Integer>{


}
