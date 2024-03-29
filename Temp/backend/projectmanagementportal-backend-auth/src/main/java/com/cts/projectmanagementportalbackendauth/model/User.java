package com.cts.projectmanagementportalbackendauth.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	
	@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters")
	private String userName;
	
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
	@ManyToOne
	private Role role;
	
	@NotNull(message = "password should not be Null")
	@Size(min = 8, message = "size should 8 characters or more")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="must contain one lower case, one upper case, one numeric and one symbol")
	private String password;

	public Role getRoles() {
		return role;
	}

	public void setRole(Role roles) {
		this.role = roles;
	}

	

}
