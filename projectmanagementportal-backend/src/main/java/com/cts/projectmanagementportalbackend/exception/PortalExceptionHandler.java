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
	
	/**invalid user exception handler
	 * @param InvalidUserIdOrPasswordException
	 * @return ResponseEntity<MessageResponse>
	 * 
	 * @author Kollimarla Jagadeep
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserIdOrPasswordException.class)
	public ResponseEntity<MessageResponse> handleIInvalidUserIdOrPasswordException(InvalidUserIdOrPasswordException ie) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(ie.getMessage());
		messageResponse.setStatus(HttpStatus.UNAUTHORIZED);
		messageResponse.setTimeStamp(new Date());
		return new ResponseEntity<>(messageResponse, HttpStatus.UNAUTHORIZED);

	}
	
	/**invalid user exception handler
	 * @param IdAlreadyExistException
	 * @return ResponseEntity<MessageResponse>
	 * 
	 * @author Kollimarla Jagadeep
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IdAlreadyExistException.class)
	public ResponseEntity<MessageResponse> handleIdAlreadyExistException(IdAlreadyExistException ie) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(ie.getMessage());
		messageResponse.setStatus(HttpStatus.BAD_REQUEST);
		messageResponse.setTimeStamp(new Date());
		return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);

	}
	
	/**invalid user exception handler
	 * @param TeamSizeExcedsException
	 * @return ResponseEntity<MessageResponse>
	 * 
	 * @author Kollimarla Jagadeep
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TeamSizeExcedsException.class)
	public ResponseEntity<MessageResponse> handleTeamSizeExcedsException(TeamSizeExcedsException ie) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(ie.getMessage());
		messageResponse.setStatus(HttpStatus.BAD_REQUEST);
		messageResponse.setTimeStamp(new Date());
		return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);

	}

	/**invalid user exception handler
	 * @param NoSuchElementExistException
	 * @return ResponseEntity<MessageResponse>
	 * 
	 * @author Kollimarla Jagadeep
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementExistException.class)
	public ResponseEntity<MessageResponse> handleNoSuchElementExistException(NoSuchElementExistException ie) {
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(ie.getMessage());
		messageResponse.setStatus(HttpStatus.NOT_FOUND);
		messageResponse.setTimeStamp(new Date());
		return new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);

	}
}
