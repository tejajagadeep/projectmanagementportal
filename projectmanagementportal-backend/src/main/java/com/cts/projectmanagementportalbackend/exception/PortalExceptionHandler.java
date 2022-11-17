package com.cts.projectmanagementportalbackend.exception;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.projectmanagementportalbackend.model.MessageResponse;

//global exception handler for all the exceptions
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PortalExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**invalid user exception handler
	 * @param InvalidUserException
	 * @return ResponseEntity<MessageResponse>
	 * 
	 * @author Kollimarla Jagadeep
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<MessageResponse> handleInvalidUserException(InvalidUserException ie) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(ie.getMessage());
		messageResponse.setStatus(HttpStatus.BAD_REQUEST);
		messageResponse.setTimeStamp(new Date());
		return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);

	}

}
