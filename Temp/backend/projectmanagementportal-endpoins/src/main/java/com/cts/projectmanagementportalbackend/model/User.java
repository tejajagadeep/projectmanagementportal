package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "UserEmp")
@Entity
public class User {

	@Id
	@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters")
	private String userId;
	
	@NotNull(message = "name should not be Null")
	@NotEmpty(message = "name shoudl not be Empty")
	@Size(max = 100)
	private String name;
	
	@NotNull(message = "emailAddress should not be Null")
	@NotEmpty(message = "emailAddress should not be Empty")
	@Size(max = 100)
	@Email(message = "enter valid email address")
	private String emailAddress;
	
	@NotNull(message = "contactNo should not be Null")
//	@Size(min = 10, max = 10, message = "contactNo should be 10 digits")
	@Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits")
	private Long contactNo;
	
//	@NotNull(message = "dateOfBirth should not be Null")
//	@NotEmpty(message = "projectEndDate should not be empty")
//	private String dateOfBirth;
	
	@NotNull(message = "dateOfBirth should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@NotEmpty(message = "projectEndDate should not be empty")
	private Date dateOfBirth;
	
	@NotNull(message = "userType should not be Null")
	@NotEmpty(message = "userType should not be Empty")
	@Size(max = 100)
	private String userType;
	
	@NotNull(message = "password should not be Null")
	@Size(min = 8, message = "size should 8 characters or more")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="must contain one lower case, one upper case, one numeric and one symbol")
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

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public User(@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters") String userId,
			@NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") @Size(max = 100) String name,
			@NotNull(message = "emailAddress should not be Null") @NotEmpty(message = "emailAddress should not be Empty") @Size(max = 100) @Email(message = "enter valid email address") String emailAddress,
			@NotNull(message = "contactNo should not be Null") @Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits") Long contactNo,
			@NotNull(message = "dateOfBirth should not be Null") Date dateOfBirth,
			@NotNull(message = "userType should not be Null") @NotEmpty(message = "userType should not be Empty") @Size(max = 100) String userType,
			@NotNull(message = "password should not be Null") @Size(min = 8, message = "size should 8 characters or more") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "must contain one lower case, one upper case, one numeric and one symbol") String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.userType = userType;
		this.password = password;
	}

	public User() {
		super();
	}

	
	
	
}
