package com.registerpatient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registerpatient.repository.CapacityRepository;

@Service
public class CapacityManager {

	@Autowired
	private CapacityRepository capacityRepository;

//	public List<RoomCapacity> getAllRooms() {
//		return capacityRepository.findAll();
//	}
}
