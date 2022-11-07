package com.cts.projectmanagementportalbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.cts.projectmanagementportalbackend.model.ErrorMessages;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{userId}")
	@Operation(summary = "Returns a User", description = "Takes Id and returns single User" ) //method level
	public @ApiResponse(description = "Demo Object") User getAllUsers(@Parameter(description = "Id of the Demo") @PathVariable String userId) throws NoSuchElementExistException{
		return userService.getUserById(userId);
	}
	
	
	@PostMapping("/userSignUp")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws ElementAlreadyExistException{
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	
	
}
