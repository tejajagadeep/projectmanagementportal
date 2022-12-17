package com.cts.projectmanagementportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByEmailAddress(String emailAddress);
	
	public User findByUserName(String userName);

	public User findByName(String name);

//	public List<String> findAllEmailAddress();
	
}
