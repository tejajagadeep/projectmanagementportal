package com.cts.projectmanagementportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailAddress(String emailAddress);
	public User findByUserName(String userName);
	
}
