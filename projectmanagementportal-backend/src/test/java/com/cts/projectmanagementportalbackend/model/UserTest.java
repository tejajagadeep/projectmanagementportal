package com.cts.projectmanagementportalbackend.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {

	@InjectMocks
	User user;
	
	@InjectMocks
	Project project;
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	User userNo = new User();
	
	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

	@Test
	void testGetterSetterUserName() {
		user.setUserName("jagadep");
		assertEquals("jagadep", user.getUserName());
	}

	@Test
	void testGetterSetterName() {
		user.setName("jagadeep");
		assertEquals("jagadeep", user.getName());
	}

	@Test
	void testGetterSetterEmailAddress() {
		user.setEmailAddress("jagadeep@gmail.com");
		assertEquals("jagadeep@gmail.com", user.getEmailAddress());
	}

	@Test
	void testGetterSetterContactNo() {
		user.setContactNo(78945612310L);
		assertEquals(78945612310L, user.getContactNo());
	}

	@Test
	void testGetterSetterDateOfBirth() {
		user.setDateOfBirth(date);
		assertEquals(date, user.getDateOfBirth());
	}

	@Test
	void testGetterSetterRole() {
		user.setRole("ADMIN");
		assertEquals("ADMIN", user.getRole());
	}

	@Test
	void testGetterSetterPassword() {
		user.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");
		assertEquals("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm", user.getPassword());
	}
	
	@Test
	void testGetterSetterProjects() {
		Set<Project> assginProject = new HashSet<>();
		assginProject.add(project);
		user.setProjects(assginProject);
		assertEquals(assginProject,user.getProjects());
	}
	
	@Test
	void testUserNoArgs() {
		User userNo = new User();
		User userN = new User();
		assertEquals(userN.getClass(),userNo.getClass());
	}

	@Test
	void testaddProjects() {
		Set<Project> assginProject = new HashSet<>();
		assginProject.add(project);
		user.addProjects(project);
		assertEquals(assginProject,user.getProjects());
	}
	
	@Test
	void testtoString() {
		String toString = user.toString();
		assertEquals(user.toString(),toString);
	}
}
