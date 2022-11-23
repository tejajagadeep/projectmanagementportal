package com.cts.projectmanagementportalbackend.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortalExceptionHandlerTest {

	@InjectMocks
	PortalExceptionHandler portalExceptionHandler;
	
	@Test
	void testHandleInvalidUserException() {
		assertEquals(400, portalExceptionHandler.handleInvalidUserException(new InvalidUserException(null)).getStatusCodeValue());
	}

	@Test
	void testHandleIInvalidUserIdOrPasswordException() {
		assertEquals(401, portalExceptionHandler.handleIInvalidUserIdOrPasswordException(new InvalidUserIdOrPasswordException(null)).getStatusCodeValue());
	}

	@Test
	void testHandleIdAlreadyExistException() {
		assertEquals(400, portalExceptionHandler.handleIdAlreadyExistException(new IdAlreadyExistException(null)).getStatusCodeValue());
	}

	@Test
	void testHandleTeamSizeExcedsException() {
		assertEquals(400, portalExceptionHandler.handleTeamSizeExcedsException(new TeamSizeExcedsException(null)).getStatusCodeValue());
	}

	@Test
	void testHandleNoSuchElementExistException() {
		assertEquals(404, portalExceptionHandler.handleNoSuchElementExistException(new NoSuchElementExistException(null)).getStatusCodeValue());
	}

	@Test
	void testHandleNullPointerException() {
		assertEquals(400, portalExceptionHandler.handleNullPointerException(new NullPointerException(null)).getStatusCodeValue());
	}

}
