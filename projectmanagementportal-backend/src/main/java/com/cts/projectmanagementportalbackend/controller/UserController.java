package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	UserService userService;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')") // hasRole('ROLE_MEMBER') and @userSecurity.hasUserId(authentication,#userId)
	@GetMapping("/getAllUsers/{userName}")
	public ResponseEntity<List<User>> getAllUsers(@PathVariable String userName){
		
		log.info("inside getAllUsers of User Controller");
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
//	@PreAuthorize("@userSecurity.hasUserName(authentication,#userName)")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getUserByUserName/{userName}")
//	@PostFilter("filterObject.userId==authentication.name")
	public ResponseEntity<User> getByUserName(@PathVariable String userName){
		
		log.info("inside getByUserName of User Controller");
		return new ResponseEntity<>(userService.getByUserName(userName),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getUserByName/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name){
		
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
	
	
	@PostMapping("/userSignUp")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		
		log.info("inside saveUser of User Controller");
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	
	
}
