package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Table(name = "User")
@Entity
public class User {

	@Id
	@Size(max = 100)
	private String UserId;
	
	@NotNull
	@Size(max = 100)
	private String name;
	
	@NotNull
	@Size(max = 100)
	private String emailAddress;
	
	@NotNull
	private long contactNo;
	
	@NotNull
	private Date dOB;
	
	@NotNull
	@Size(max = 100)
	private String userType;
	
	@NotNull
	@Size(max = 10)
	private String password;
}
