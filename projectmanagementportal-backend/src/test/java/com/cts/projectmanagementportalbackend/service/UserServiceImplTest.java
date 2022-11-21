package com.cts.projectmanagementportalbackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import static org.junit.Assert.assertEquals;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	User user;
	
	@Mock
	User userTest;
	
	private User userPrivate;
	
	@BeforeEach
	public void setUser(){
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		user.setUserName("jagadeep");
		user.setName("jagadeep");
		user.setEmailAddress("jagadeep@gmail.com");
		user.setContactNo(7894561230L);
		user.setDateOfBirth(date);
		user.setRole("Admin");
		user.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		userRepository.save(user);
		
//		userPrivate.setUserName("jagadep");
//		userPrivate.setName("jagadep");
//		userPrivate.setEmailAddress("jagadep@gmail.com");
//		userPrivate.setContactNo(7894561230L);
//		userPrivate.setDateOfBirth(date);
//		userPrivate.setRole("Admin");
//		userPrivate.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
//		userPrivate = User.Build
	}
	
	@Test
	void testGetAllUsers() {
		assertEquals(userRepository.findAll(),userServiceImpl.getAllUsers());
	}

	@Test
	void testGetByUserName() {
		
		String  userName = "jagadeep";
		when(userRepository.findByUserName(userName)).thenReturn(user);
		assertEquals(userRepository.findByUserName(userName),userServiceImpl.getByUserName(userName));
	}
	
	@Test
	void testGetByUserNameNull() {
		String  name = "jagadeep";
		given(userRepository.findByName(name)).willReturn(user);
		assertThrows(IdAlreadyExistException.class, () -> userServiceImpl.getByUserName(name));
//		assertNotEquals(userRepository.findByName(name),userServiceImpl.getByUserName(name));

	}
	
	@Test
	void testGetUserByName() {
		String  userName = "jagadeep";
		when(userRepository.findByName(userName)).thenReturn(user);
		assertEquals(userRepository.findByName(userName),userServiceImpl.getUserByName(userName));

	}

	@Test
	void testGetUserByNameNull() {
		String  name = "jadeep";
		when(userRepository.findByEmailAddress(name)).thenReturn(user);
		assertThrows(IdAlreadyExistException.class,() -> userServiceImpl.getUserByName(name));

	}
	@Test
	void testSaveUserNull() {
		
		String  userName = "jagadeep";
		given(userRepository.findByUserName(userName)).willReturn(null);
		
		given(userRepository.save(user)).willReturn(user);
		
		User userDummy = userServiceImpl.saveUser(user);
		System.out.println(userDummy);
		assertThat(userDummy).isNotNull();
		assertEquals(userRepository.findByUserName(userName), userDummy);
		
	}
	
	@Test
	void testSaveUser() {
		
		String dateString1 = "1999/07/28";
		Date date1 = new Date(dateString1);
		userTest.setUserName("jagadee");
		userTest.setName("jagadee");
		userTest.setEmailAddress("jagadee@gmail.com");
		userTest.setContactNo(7894561230L);
		userTest.setDateOfBirth(date1);
		userTest.setRole("Admin");
		userTest.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		
		String  userName = "jagadee";
		UserServiceImpl userService = new UserServiceImpl();
		UserServiceImpl userServiceMock = mock(UserServiceImpl.class);
		
		when(userServiceMock.saveUser(user)).thenReturn(user);
		
		userService.setSomeDataService;
		
		assertEquals(user, user);
		
	}

}
