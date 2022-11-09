package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MessageResponse {
	private Date timeStamp;
	private String message;
	private HttpStatus status;
	
	public MessageResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}
	
	
	
}
