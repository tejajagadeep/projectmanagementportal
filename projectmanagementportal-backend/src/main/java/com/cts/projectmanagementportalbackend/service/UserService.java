package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.PasswordIncorrectException;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;

public interface UserService {

	UserResponse loginUser(String user, String password) throws InvalidUserIdOrPasswordException;
	
	List<User> getAllUsers();
	
	User getUserById(int userId) throws NoSuchElementExistException;

	User saveUser(User user)  throws InvalidUserIdOrPasswordException;

	User login(String userName, String password) throws PasswordIncorrectException;
	
}
