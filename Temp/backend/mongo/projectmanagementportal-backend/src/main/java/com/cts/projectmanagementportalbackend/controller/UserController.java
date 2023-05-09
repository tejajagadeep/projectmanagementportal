package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	UserService userService;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Operation(summary = "Retrieve Users", description = "fetch all users from the database.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')") // hasRole('ROLE_MEMBER') and @userSecurity.hasUserId(authentication,#userId)
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUsers(){
		
		log.info("inside getAllUsers of User Controller");
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}

//	@PreAuthorize("@userSecurity.hasUserName(authentication,#userName)")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/userName/{userName}")
//	@PostFilter("filterObject.userId==authentication.name")
	@Operation(summary = "Retrieve User", description = "Takes in userId and Retrieves  single User details." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	public @ApiResponse(description = "200") ResponseEntity<User> getByUserName(@Parameter(description = "User Id of the User") @PathVariable String userName){
		
		log.info("inside getByUserName of User Controller");
		return new ResponseEntity<>(userService.getByUserName(userName),HttpStatus.OK);
	}
	@Operation(summary = "Retrieve User", description = "Takes in name and Retrieves single User details.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/name/{name}")
	public @ApiResponse(description = "200") ResponseEntity<User> getUserByName(@Parameter(description = "User name of the User") @PathVariable String name){
		
		log.info("inside getByUserName of User Controller");
		return new ResponseEntity<>(userService.getUserByName(name),HttpStatus.OK);
	}

//	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
//	@GetMapping("/getUserByUserId/{userId}")
////	@PostFilter("filterObject.userId==authentication.name")
//	@Operation(summary = "Returns a User", description = "Takes Id and returns single User" ) //method level
//	public @ApiResponse(description = "Demo Object") User getByUserId(@Parameter(description = "Id of the Demo") @PathVariable int userId){
//		
//		log.info("inside getUserById of User Controller");
//		return userService.getByUserId(userId);
//	}

	@Operation(summary = "Sign up New User", description = "User gives the user details which are stored in the database.")
	@PostMapping("/userSignUp")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Enter User Details") @Valid @RequestBody User user){
		
		log.info("inside saveUser of User Controller");
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	
	
}
