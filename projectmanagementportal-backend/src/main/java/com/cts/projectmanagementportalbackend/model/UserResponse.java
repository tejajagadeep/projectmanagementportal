package com.cts.projectmanagementportalbackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
	
	private User user;
	private String loginStatus;
	private String token;
	private String ErrorMessage;
	private String userName;
	private String role;
	
	public UserResponse(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}
	
	

}
