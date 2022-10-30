package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.UsernameAlreadyExists;

public interface UserService {

	List<User> getAllUsers();

	User saveUser(User user)  throws UsernameAlreadyExists;

	User getUserById(String userId);

//	User loginUser(User user);

	User getUserByUserIdAndPassword(String userId, String password);

	UserResponse loginUser(String userId, String password) throws InvalidUserIdOrPasswordException;

}
