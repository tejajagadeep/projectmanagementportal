package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.model.HelloWorld;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/helloWorld")
	public HelloWorld helloWorld() {
//		throw new RuntimeException("runtime Exception");
		return new HelloWorld("HelloWorld Back-End", 1);
	}
	
	@GetMapping("/helloWorld/{name}")
	public HelloWorld helloWorldPathVaraible(@PathVariable String name) {
//		throw new RuntimeException("runtime Exception");
		return new HelloWorld(name, 1);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/userSignUp")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	
}
