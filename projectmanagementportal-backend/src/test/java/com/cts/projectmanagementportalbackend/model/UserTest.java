package com.cts.projectmanagementportalbackend.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
	
	@InjectMocks
	User user;
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	
//	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");

	@Test
	void testGetterSetterUserId() {
		user.setUserId("jagadep");
		assertEquals("jagadep", user.getUserId());
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

//	@Test
//	void testGetterSetterDateOfBirth() {
//		user.setDateOfBirth("date");
//		assertEquals("date", user.getDateOfBirth());
//	}

	@Test
	void testGetterSetterUserType() {
		user.setUserType("ADMIN");
		assertEquals("ADMIN", user.getUserType());
	}

	@Test
	void testGetterSetterPassword() {
		user.setPassword("789456123");
		assertEquals("789456123", user.getPassword());
	}

//	@Test
//	void testUserStringStringStringLongDateStringString() {
////		User userDummy = new User(userObject);
//		assertEquals(userObject, user);
//	}
//
//	@Test
//	void testUser() {
//		assertEquals(,);
//	}

}
