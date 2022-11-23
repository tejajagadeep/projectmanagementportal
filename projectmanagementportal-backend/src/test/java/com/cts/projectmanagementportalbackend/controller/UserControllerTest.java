package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.service.UserService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	List<User> userList;
	User user;
	
	@Test
	@Order(1)
	void testGetAllUsers() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		
		userList = new ArrayList<>();
		userList.add( new User("user1","user1","user1@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm"));
		userList.add( new User("user2","user2","user2@gmail.com",78945612311L,date,"MEMBER","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm"));
		
		when(userService.getAllUsers()).thenReturn(userList);
		ResponseEntity<List<User>> response = userController.getAllUsers("user1");
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}

	@Test
	@Order(2)
	void testGetByUserName() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		user =  new User("user1","user1","user1@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		when(userService.getByUserName("user1")).thenReturn(user);
		ResponseEntity<User> response = userController.getByUserName("user1");
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Test
	@Order(3)
	void testGetUserByName() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		user =  new User("user1","user1","user1@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		when(userService.getUserByName("user1")).thenReturn(user);
		ResponseEntity<User> response = userController.getUserByName("user1");
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Test
	@Order(4)
	void testSaveUser() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		user =  new User("user1","user1","user1@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		when(userService.saveUser(user)).thenReturn(user);
		ResponseEntity<User> response = userController.saveUser(user);
		assertEquals(HttpStatus.CREATED,response.getStatusCode());
	}

}
