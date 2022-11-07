package com.auth.server.model;

import java.io.Serializable;
import java.util.Calendar;
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






@Table(name="user")
@Entity
public class User implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private static final long serialVersionUID = 983648238746032841L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters")
	@NotNull(message = "name should not be Null")
	@NotEmpty(message = "name shoudl not be Empty")
	private String userName;
	
	@NotNull(message = "name should not be Null")
	@NotEmpty(message = "name shoudl not be Empty")
	@Size(max = 100)
	private String name;
	
	
	
	
	
//	@ManyToMany(mappedBy = "consumers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Utility> utilitites;
	
	@NotNull(message = "emailAddress should not be Null")
	@NotEmpty(message = "emailAddress should not be Empty")
	@Size(max = 100)
	@Email(message = "enter valid email address")
	private String emailAddress;
	
	@Column(name="contact_number")
	@NotNull(message = "contactNo should not be Null")
//	@Size(min = 10, max = 10, message = "contactNo should be 10 digits")
	@Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits")
	private Long contactNumber;
	
	@NotNull(message = "userType should not be Null")
	@NotEmpty(message = "userType should not be Empty")
	@Size(max = 100)
	@Column(name="user_type")
	private String userType;
	
	@Column(name="dob")
	@NotNull(message = "dateOfBirth should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfBirth;
	
	@NotNull(message = "password should not be Null")
	@NotEmpty(message = "password should not be Empty")
//	@Size(min = 8, message = "size should 8 characters or more")
//	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="must contain one lower case, one upper case, one numeric and one symbol")
	private String password;
	
	@ManyToOne
	private Role role;

	public User() {
		super();
	}

		
	public User(int userId, String userName, String userType, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password=password;
		this.dateOfBirth = Calendar.getInstance().getTime();
		
	}
	
	public User(String userName, String userType, String password) {
		
		this.userName = userName;
		this.password=password;
	}

	

	public User(int userId,
			@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters") @NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") String userName,
			@NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") @Size(max = 100) String name,
			@NotNull(message = "emailAddress should not be Null") @NotEmpty(message = "emailAddress should not be Empty") @Size(max = 100) @Email(message = "enter valid email address") String emailAddress,
			@NotNull(message = "contactNo should not be Null") @Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits") Long contactNumber,
			@NotNull(message = "userType should not be Null") @NotEmpty(message = "userType should not be Empty") @Size(max = 100) String userType,
			@NotNull(message = "dateOfBirth should not be Null") Date dateOfBirth,
			@NotNull(message = "password should not be Null") @NotEmpty(message = "password should not be Empty") String password,
			Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
		this.userType = userType;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	

	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRoles() {
		return role;
	}

	public void setRole(Role roles) {
		this.role = roles;
	}
	
	
	
}
