package com.cts.projectmanagementportalbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserRole {
	
	@Id
	private String userId;
	private String password;
	private String role;
	private String roleDescription;
	
}
