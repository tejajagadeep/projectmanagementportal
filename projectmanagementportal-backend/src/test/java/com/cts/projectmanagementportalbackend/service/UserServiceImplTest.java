package com.cts.projectmanagementportalbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	User user;
	
	@Mock
	private static List<User> userList = new ArrayList<>();
	
	@Mock
	UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	
//	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");
//	User userNullObject = new User(); 
//	
//	static String dateStringStatic = "1999/07/28";
//	static Date dateStatic = new Date(dateStringStatic);
//	static {
//		userList.add(new User("jagadep1","jagadep1","jagadeep1@gmail.com",78945612311L,"dateStatic","ADMIN","789456123"));
//		userList.add(new User("jagadep2","jagadep2","jagadeep2@gmail.com",78945612312L,"dateStatic","ADMIN","789456123"));
//		userList.add(new User("jagadep3","jagadep3","jagadeep3@gmail.com",78945612313L,"dateStatic","ADMIN","789456123"));
//	}
	
	@DisplayName("JUnit test for getAllUsers method")
	@Test
	void testGetAllUsers() {
		userRepository.saveAll(userList);
//		Mockito.when(userServiceImpl.getAllUsers()).thenReturn(userRepository.findAll());
		when(userServiceImpl.getAllUsers()).thenReturn(userRepository.findAll());
//		System.out.println(userRepository.findAll());
		log.debug(dateString, userRepository.findAll());
		assertEquals(userRepository.findAll(),userServiceImpl.getAllUsers());
	}

//	@Test
//	void testSaveUser() {
//		
////		User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945,date,"ADMIN","789456123");
//		
//		Mockito.when(userRepository.save(userObject)).thenReturn(userObject);
//		
//		assertThat(userServiceImpl.saveUser(userObject)).isEqualTo(userObject);
//		assertEquals(userServiceImpl.saveUser(userObject), userObject);
//	}
	
	
	@Test
	void testSaveUserException() throws ElementAlreadyExistException {
		
//		user=null;
		user.setUserId(null);
		Optional<User> userOptional = userRepository.findById(user.getUserId());
		
		when(userServiceImpl.saveUser(user)).thenReturn(user);
		assertThrows(RuntimeException.class, () -> userServiceImpl.saveUser(null));
		
	}

//	@Test
//	void testGetUserById() {
//		fail("Not yet implemented");
//	}

}
