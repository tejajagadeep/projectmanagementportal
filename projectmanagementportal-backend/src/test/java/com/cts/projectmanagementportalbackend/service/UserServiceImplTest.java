package com.cts.projectmanagementportalbackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

//import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

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
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@MockBean
	UserRepository userRepositoryBean;
	
	@Autowired
	UserServiceImpl userServiceA;
	
	@Mock
	User user;
	
	@Mock
	User userTest;
	
	private User userPrivate;
	
	@BeforeEach
	public void setUser(){
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		User user2 = new User();
		user2.setUserName("jagadeep");
		user2.setName("jagadeep");
		user2.setEmailAddress("jagadeep@gmail.com");
		user2.setContactNo(7894561230L);
		user2.setDateOfBirth(date);
		user2.setRole("Admin");
		user2.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		
		User user1 = new User();
		user1.setUserName("jagad");
		user1.setName("jagad");
		user1.setEmailAddress("jagad@gmail.com");
		user1.setContactNo(7894561230L);
		user1.setDateOfBirth(date);
		user1.setRole("Admin");
		user1.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		when(userRepository.findAll()).thenReturn(userList);
		System.out.println("user setup : "+ user.getPassword());
		
				
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
	void testGetUsreByNameNull() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		User userNew = new User();
		
		
		userNew.setUserName("username");
		userNew.setName("name");
		userNew.setEmailAddress("email@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		String  name = "jadeep";
		when(userRepository.findByName("name")).thenReturn(userNew);
		assertThrows(InvalidUserException.class,() -> userServiceImpl.getUserByName(name));

	}
	
	@Test
	void testGetByUserNameNull() {
		String  userName = "jagadeep";
		when(userRepository.findByName(userName)).thenReturn(user);
		assertEquals(userRepository.findByName(userName),userServiceImpl.getUserByName(userName));

	}

	@Test
	void testGetUserByNameNull() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		User userNew = new User();
		
		
		userNew.setUserName("username");
		userNew.setName("name");
		userNew.setEmailAddress("email@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		String  name = "jadeep";
		when(userRepository.findByUserName("username")).thenReturn(userNew);
		assertThrows(InvalidUserException.class,() -> userServiceImpl.getByUserName(name));

	}
	@Test
	void testSaveUserNull() {
		
		String  userName = "jagadeep";
		given(userRepository.findByUserName(userName)).willReturn(null);
		
		given(userRepository.save(user)).willReturn(user);
		
//		User userDummy = userServiceImpl.saveUser(user);
//		System.out.println(userDummy);
//		assertThat(userDummy).isNotNull();
//		assertEquals(userRepository.findByUserName(userName), userDummy);
		
	}
	
	@Test
	void testSaveUser() {
		System.out.println("user setup save: "+ user.getPassword());
		String dateString1 = "1999/07/28";
		Date date1 = new Date(dateString1);
		userTest.setUserName("jagadee");
		userTest.setName("jagadee");
		userTest.setEmailAddress("jagadee@gmail.com");
		userTest.setContactNo(7894561230L);
		userTest.setDateOfBirth(date1);
		userTest.setRole("Admin");
		userTest.setPassword("ABCabc@123");
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userTest);
		when(userRepository.findByEmailAddress("jagadee@gmail.com")).thenReturn(userTest);
		when(userRepository.save(userTest)).thenReturn(userTest);
		
//		assertThrows(IdAlreadyExistException.class,()-> userServiceImpl.saveUser(userTest));
		
	}
	
	@Test
	void testSaveUserBean() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(userRepositoryBean.save(userNew)).thenReturn(userNew);
		
		User userDummy = userServiceA.saveUser(userNew);
		assertEquals(userNew, userServiceA.saveUser(userNew));
	}

}
