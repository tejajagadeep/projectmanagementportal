package com.cts.projectmanagementportalbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByEmailAddress(String emailAddress);
	
	public User findByUserName(String userName);

	public User findByName(String name);

//	public List<String> findAllEmailAddress();
	
}
