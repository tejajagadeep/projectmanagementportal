package com.cts.projectmanagementportalbackend.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;

@RestControllerAdvice
public class ExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> hadleMethodArgumentNotValidException(MethodArgumentNotValidException exMANV){
		log.info("inside hadleMethodArgumentNotValidException of ExceptionHandler");
		Map<String, String> errorMap = new HashMap<>();
		exMANV.getBindingResult().getFieldErrors()
		.forEach(
				error -> {
					errorMap.put(error.getField(), error.getDefaultMessage());
				}
				);
		return errorMap;
	}
	
	
	
}
