package com.cts.projectmanagementportalbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
import com.cts.projectmanagementportalbackend.exception.PasswordIncorrectException;
import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
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
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
//	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@PostMapping("login/{userName}/{password}")
	public ResponseEntity<User> login(@PathVariable String userName, @PathVariable String password) throws PasswordIncorrectException{
		
		log.info("inside login of User Controller");
		return new ResponseEntity<>(userService.login(userName, password),HttpStatus.OK);
	}

	
//	@PostMapping("/loginuser")
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<UserResponse> loginUser(Model model, @RequestBody User user, HttpServletRequest request) throws InvalidUserIdOrPasswordException{
//		
//		try {
//			 UserResponse authUser = userService.loginUser(user.getUserId(), user.getPassword());
//			System.out.print(authUser);
//			if (authUser != null) {
//				request.getSession().setAttribute("user", user.getUserId());
//				return new ResponseEntity<UserResponse>(authUser, HttpStatus.OK);
//			} else {
//				throw new InvalidUserIdOrPasswordException(ErrorMessages.INVALID_CREDENTIALS.getMessage());
//			}
//		} catch (InvalidUserIdOrPasswordException e) {
//			throw new InvalidUserIdOrPasswordException(ErrorMessages.INVALID_CREDENTIALS.getMessage());
//		}
//		
//	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')") // hasRole('ROLE_MEMBER') and @userSecurity.hasUserId(authentication,#userId)
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		log.info("inside getAllUsers of User Controller");
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@GetMapping("/getUserById/{userId}")
//	@PostFilter("filterObject.userId==authentication.name")
	@Operation(summary = "Returns a User", description = "Takes Id and returns single User" ) //method level
	public @ApiResponse(description = "Demo Object") User getAllUsers(@Parameter(description = "Id of the Demo") @PathVariable int userId) throws NoSuchElementExistException{
		
		log.info("inside getUserById of User Controller");
		return userService.getUserById(userId);
	}
	
	
	@PostMapping("/userSignUp")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws InvalidUserIdOrPasswordException{
		
		log.info("inside saveUser of User Controller");
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	
	
}
