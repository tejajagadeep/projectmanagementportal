package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = UserController.class)
class UserControllerTest {

	@MockBean
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final String User_URL = "api/products/";
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);

	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");
	
	
//	@Test
//	void testHelloWorld() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testHelloWorldPathVaraible() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetAllUsers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllUsersString() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSaveUser() throws Exception {
		User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");
		when(userService.saveUser(ArgumentMatchers.any())).thenReturn(userService.saveUser(userObject));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String userJson = objectMapper.writeValueAsString(userObject);
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilders = MockMvcRequestBuilders.post("/api/user/userSignUp").accept(MediaType.APPLICATION_JSON).content(userJson);
		
		ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilders);
		
		MvcResult mvcResult = resultActions.andReturn();
		
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		
		int status = mockHttpServletResponse.getStatus();
		
		assertEquals(201, status);
	}
	
	@Test
	void testSaveUser2() throws Exception{
//		ResponseEntity<User> responseEntityUser = new ResponseEntity<>(user.)
	}

}
