package com.cts.projectmanagementportalbackend.jwt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtRequestTest {
	
	@InjectMocks
	JwtRequest jwtRequest;
	
	JwtRequest jet = new JwtRequest("","");

	@Test
	void testJwtRequest() {
	}

	@Test
	void testGetUsername() {
		jwtRequest.setUsername("thunder");
		assertEquals("thunder", jwtRequest.getUsername());
	}

	@Test
	void testGetPassword() {
		jwtRequest.setPassword("thunder");
		assertEquals("thunder", jwtRequest.getPassword());
	}

}
