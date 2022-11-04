package com.cts.projectmanagementportalbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
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
	
	@MockBean
	UserRepository beanRepository;
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserServiceImpl userService;
	
	Logger logger = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	
	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
//	User userNullObject = new User(); 
//	
//	static String dateStringStatic = "1999/07/28";
//	static Date dateStatic = new Date(dateStringStatic);
//	static {
//		userList.add(new User("jagadep1","jagadep1","jagadeep1@gmail.com",78945612311L,"dateStatic","ADMIN","789456123"));
//		userList.add(new User("jagadep2","jagadep2","jagadeep2@gmail.com",78945612312L,"dateStatic","ADMIN","789456123"));
//		userList.add(new User("jagadep3","jagadep3","jagadeep3@gmail.com",78945612313L,"dateStatic","ADMIN","789456123"));
//	}
	
//	@BeforeEach
//	void setUp() throws Exception{
//		MockitoAnnotations.initMocks(this);
//	}
	
	@DisplayName("JUnit test for getAllUsers method")
	@Test
	void testGetAllUsers() {
		when(userRepository.findAll()).thenReturn(Arrays.asList(new User("jagadep1","jagadep1","jagadeep1@gmail.com",78945612311L,date,"ADMIN","789456123"),
				new User("jagadep1","jagadep1","jagadeep1@gmail.com",78945612311L,date,"ADMIN","789456123")));
		
		
		assertEquals(userRepository.findAll(),userServiceImpl.getAllUsers());
	}

	
	@Test
	void testSaveUser() throws ElementAlreadyExistException {
		
		User user1 = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
		User user2 = new User("jagadep1","jagadep1","jagadeep1@gmail.com",78945612310L,date,"ADMIN","789456123");
		
		when(beanRepository.save(user1)).thenReturn(user1);
		
		assertEquals(user1, userService.saveUser(user1));
	}
	
	@Test
	void testSaveUser1() throws ElementAlreadyExistException {
		
		User user1 = new User("venkat","Venkat","Vankat@gmail.com",78945612310L,date,"ADMIN","Venkat@123");
		
		when(repository.save(user1)).thenReturn(user1);
		
		assertThrows(ElementAlreadyExistException.class, () -> userService.saveUser(user1));
	}
	
//	@Test
//	void testSaveUserException() throws ElementAlreadyExistException {
//		
////		user=null;
//		Optional<User> userOptional = userRepository.findById("venkat");
//		User user = new User("vekat","Vankat","Vankat@gmail.com",78945612310L,date,"ADMIN","Venkat@123");
//		userRepository.save(user);
//		when(userRepository.findByUserId("jagadep")).thenReturn(user);
//		assertThrows(ElementAlreadyExistException.class, () -> userServiceImpl.saveUser(user));
//		
//	}
	
//	@Test
//	void testGetUserById() throws NoSuchElementExistException {
//		
//		User user = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
//		userRepository.save(user);
//		when(userServiceImpl.getUserById("jagadep")).thenReturn(user);
//		
//		User userDto = userServiceImpl.getUserById("jagadep1");
//		
//		assertNotNull(userDto);
//		assertEquals(userRepository.findById("jagadep1"),userServiceImpl.getUserById("jagadep1"));
//	}
	
	@Test
	void testGetUserById3() throws NoSuchElementExistException {
		
		User userObj = new User("venkat","vVnkat","venkat@gmail.com",78945612311L,date,"ADMIN","Venakt@123");
		userService.getUserById(user.getUserId());
		assertEquals("Venkat",userServiceImpl.getUserById("venkat").getName());
//		assertEquals(userRepository.findById("venkat").get(),userServiceImpl.getUserById("venkat"));
	}
	

}
