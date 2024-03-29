package com.cts.projectmanagementportalbackend.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "UserEmp")
@Entity
//@Getter //8
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userId;
//	
//	@NotNull(message = "username should not be Null")
//	@NotEmpty(message = "username shoudl not be Empty")
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
	@JsonFormat(pattern ="yyyy-MM-dd")
//	@NotEmpty(message = "projectEndDate should not be empty")
	private Date dateOfBirth;
	
	@NotNull(message = "Role should not be Null")
	@NotEmpty(message = "Role should not be Empty")
	@Size(max = 100)
	private String role;
	
//	@NotNull(message = "userType should not be Null")
//	@NotEmpty(message = "userType should not be Empty")
//	@Size(max = 100)
//	private String userType;
	
	@NotNull(message = "password should not be Null")
	@Size(min = 8, message = "size should 8 characters or more")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="must contain one lower case, one upper case, one numeric and one symbol")
	private String password;

	@OneToMany(cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
	})
	@JoinColumn(name = "user_name")
	private Set<Project> projects;
	
	public void addProjects(Project theProject) {

		if (projects == null) {
//			storyAssignedToUsers = new ArrayList<>();
			projects = new HashSet<>();
		}

		projects.add(theProject);

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public String getUserType() {
//		return userType;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", emailAddress=" + emailAddress + ", contactNo="
				+ contactNo + ", dateOfBirth=" + dateOfBirth + ", role=" + role + ", password=" + password
				+ ", projects=" + projects + "]";
	}

	

	public User(@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters") String userName,
			@NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") @Size(max = 100) String name,
			@NotNull(message = "emailAddress should not be Null") @NotEmpty(message = "emailAddress should not be Empty") @Size(max = 100) @Email(message = "enter valid email address") String emailAddress,
			@NotNull(message = "contactNo should not be Null") @Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits") Long contactNo,
			@NotNull(message = "dateOfBirth should not be Null") Date dateOfBirth,
			@NotNull(message = "Role should not be Null") @NotEmpty(message = "Role should not be Empty") @Size(max = 100) String role,
			@NotNull(message = "password should not be Null") @Size(min = 8, message = "size should 8 characters or more") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "must contain one lower case, one upper case, one numeric and one symbol") String password) {
		super();
		this.userName = userName;
		this.name = name;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.password = password;
	}

	public User() {
		super();
	}
	
	
}
