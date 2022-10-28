package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.model.User;

public interface UserService {

	List<User> getAllUsers();

	User saveUser(User user);

	User getUserById(String userId);

}
