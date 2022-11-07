package com.cts.projectmanagementportalbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	
	private User user;
	private String loginStatus;
	private String token;
	private String ErrorMessage;
	

	
}
