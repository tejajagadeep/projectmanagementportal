package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;

public interface UserService {

	List<User> getAllUsers(String userName);
	
	User getByUserName(String userName) throws InvalidUserIdOrPasswordException;
	
	User getByUserId(int userId) throws InvalidUserIdOrPasswordException;

	User saveUser(User user)  throws InvalidUserIdOrPasswordException;

	User login(String userName, String password) throws InvalidUserIdOrPasswordException;

	User getUserByName(String name)  throws InvalidUserIdOrPasswordException;
	
}
