package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.UserRole;
import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;
import com.cts.projectmanagementportalbackend.service.UserRoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping("/getUserRoles")
	public List<UserRole> getUserRoles(){
		return userRoleService.getUserRoles();
	}
	
	@GetMapping("/getUserRoleById/{userId}")
	public UserRole getUserRoleById(@PathVariable int userId) throws NoSuchElementExistException{
		return userRoleService.getUserRoleById(userId);
	}
	
	@GetMapping("/getUserRoleByUserName/{userName}")
	public UserRole getUserRoleByUserName(@PathVariable String userName)  throws NoSuchElementExistException{
		return userRoleService.getUserRoleByUserName(userName);
	}
	
	@PostMapping("loginAdmin")
	public UserRole loginAdmin(@Valid @RequestBody UserRole userRole) {
		return userRoleService.loginAdmin(userRole);
	}
	
	@PostMapping("loginUser")
	public UserRole loginUser(@Valid @RequestBody UserRole userRole) {
		return userRoleService.loginUser(userRole);
	}
	
}
