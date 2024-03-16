package com.registerpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.registerpatient.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	

	@Query("select u from User u where u.mailId = :mailId")
	public User getUserByUserName(@Param("mailId") String email);
}
