package com.cts.projectmanagementportalbackend.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
class ExceptionHandlerTest {
	
	@InjectMocks
	ExceptionHandler exceptionHandler;

	@Test
	void testHadleMethodArgumentNotValidException() {
//		assertEquals(400, exceptionHandler.hadleMethodArgumentNotValidException(new MethodArgumentNotValidException(null, null)));
	}

}
