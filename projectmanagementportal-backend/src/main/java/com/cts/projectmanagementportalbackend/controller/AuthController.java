package com.cts.projectmanagementportalbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager auth;
	

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@PostMapping("/login")
	public ResponseEntity<String>  authenticateUser(@RequestBody User user) {
		
		Authentication authentication = auth.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@PostMapping("/basicauth")
	public ResponseEntity<String>  authenticateUser1() {
		log.info("basicauth");
		
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
}
