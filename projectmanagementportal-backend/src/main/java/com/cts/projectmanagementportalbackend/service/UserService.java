package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;

public interface UserService {

	List<User> getAllUsers();
	
	User getByUserName(String userName) ;
	
//	User getByUserId(int userId);

	User saveUser(User user) ;

	User getUserByName(String name) ;

	List<String> getUserEmailId();

	List<String> getUserNames();
	
}
