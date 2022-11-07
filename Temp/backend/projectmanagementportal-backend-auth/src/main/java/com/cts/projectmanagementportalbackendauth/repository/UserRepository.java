package com.cts.projectmanagementportalbackendauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.projectmanagementportalbackendauth.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserName(String userName);

}
