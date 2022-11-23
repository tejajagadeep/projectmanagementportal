package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.projectmanagementportalbackend.service.UserService;

@SpringBootTest
class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;

	@Test
	void testGetAllUsers() {
		
	}

	@Test
	void testGetByUserName() {
	}

	@Test
	void testGetUserByName() {
	}

	@Test
	void testSaveUser() {
	}

}
