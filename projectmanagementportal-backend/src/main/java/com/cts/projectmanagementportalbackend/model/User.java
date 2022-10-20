package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Table(name = "UserEmp")
@Entity
public class User {

	@Id
	@Size(max = 100)
	private String userId;
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(@Size(max = 100) String userId, @NotNull @Size(max = 100) String name,
			@NotNull @Size(max = 100) String emailAddress, @NotNull long contactNo, @NotNull Date dOB,
			@NotNull @Size(max = 100) String userType, @NotNull @Size(max = 10) String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.dOB = dOB;
		this.userType = userType;
		this.password = password;
	}

	public User() {
		super();
	}
	
	
}
