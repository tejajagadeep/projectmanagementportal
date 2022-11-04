package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getUserById(String userId) throws NoSuchElementExistException;

	User saveUser(User user)  throws ElementAlreadyExistException;
	
}
