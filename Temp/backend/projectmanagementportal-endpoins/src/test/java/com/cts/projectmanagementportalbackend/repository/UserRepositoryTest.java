package com.cts.projectmanagementportalbackend.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cts.projectmanagementportalbackend.model.User;

@DataJpaTest
class UserRepositoryTest {

	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	
	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");

	
//	@Test
//	void testSaveUser() {
//		
//		User user = userObject;
//		
//		User savedInDB = entityManager.persist(user);
//		User getFromDB = userRepository.findByUserId(savedInDB.getUserId());
//		
//		assertEquals(savedInDB, getFromDB);
//	}
	
	@Test
	void testfindAll() {
		List<User> userList = userRepository.findAll();
		 
		assertEquals(3, userList.size());
	}

}
