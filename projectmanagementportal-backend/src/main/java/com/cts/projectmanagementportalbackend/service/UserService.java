package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;

public interface UserService {

	List<User> getAllUsers(String userName);
	
	User getByUserName(String userName) throws InvalidUserIdOrPasswordException;
	
	User getByUserId(int userId) throws InvalidUserIdOrPasswordException;

	User saveUser(User user)  throws InvalidUserIdOrPasswordException;

	User getUserByName(String name)  throws InvalidUserIdOrPasswordException;
	
}
