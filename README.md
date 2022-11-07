# projectmanagementportal
Project Management Tool Case Study. The client would like to develop an independent application PMP to automate the process of managing the activities of project enrollment like project registration, project status updation, project status report

insert into User_Emp(user_id, name, email_address, contact_no, dob, user_type, password) values('vinay', 'Vinay', 'vinay@gamil.com', 7894561232, '1987-12-19', 'ADMIN', '789456123');

insert into story(story_id, assignee, assignee_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story1', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project1', 'pending', 'ongoing', 'registration of employee', 'Policy Management', '2022-09-27');

insert into project(project_id, description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) values('project1', 'registration of employee', '2022-07-27', '2022-09-27', 'shekar@gmail.com', 'shekar', 'project1', 'pending', 'ongoing', 'ram@gmail.com', 'Ram', 'Team1', '3', 'stack1');

{

"userId": "12345789",

"name": "Ram",

"emailAddress": "ram@gmail.com",

"contactNo": 7894561230,

"dOB": "2022-07-26T18:30:00.000+00:00",

"userType": "CURRENT",

"password": "78945613"

}



insert into User_Emp(user_id, name, email_address, contact_no, date_of_birth, user_type, password) values('venkat', 'Venkat', 'venkat@gamil.com', 7894561230, '1978-07-27', 'USER', '789456123');

insert into User_Emp(user_id, name, email_address, contact_no, date_of_birth, user_type, password) values('rajini', 'Rajini', 'rajini@gamil.com', 7894561231, '1968-08-01', 'ADMIN', '789456123');

insert into User_Emp(user_id, name, email_address, contact_no, date_of_birth, user_type, password) values('vinay', 'Vinay', 'vinay@gamil.com', 7894561232, '1987-12-19', 'ADMIN', '789456123');


insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story1', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project1', 'pending', 'ongoing', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Policy Management', '2022-09-27');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story2', 'Hari Krishna', '2022-06-18', 'harikrishna@gmail.com', 'project2', 'pending', 'hold', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Security', '2022-10-29');

insert into story(story_id, assignee, assignment_date, assignee_email_id, project_id, remarks, status, story_description, story_title, target_date) values('story3', 'Rajan', '2022-07-27', 'rajan@gmail.com', 'project3', 'green', 'ongoing', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', 'Policy Management', '2022-09-07');


insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) values('project1', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-07-27', '2022-09-27', 'shekar@gmail.com', 'shekar', 'project1', 'pending', 'ongoing', 'ram@gmail.com', 'Ram', 'Team1', '3', 'stack1');

insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) values('project2', 'TAs Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-06-18', '2022-10-29', 'srikar@gmail.com', 'srikar', 'project2', 'pending', 'hold', 'ram@gmail.com', 'Ram', 'Team1', '3', 'stack1');

insert into project(project_id, project_description, project_start_date, project_end_date, project_manager_email_id, project_manager_name, project_name, remarks, status, tech_lead_email_id, tech_lead_name, team_name, team_size, tech_stack) values('project3', 'As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.', '2022-07-27', '2022-10-29', 'ranga@gmail.com', 'Ranga', 'project3', 'pending', 'ongoing', 'ram@gmail.com', 'Ram', 'Team1', '3', 'stack1');


# oauth2

#INSERT INTO USER (user_id,user_name,name,email_address,contact_no,user_type,dob,password,role_role_id) VALUES (1, 'Samual','Samual','samual@gmail.com',7894561230,'admin','1999-08-25,'{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',2);

UserModel
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
	
	@NotNull(message = "emailAddress should not be Null")
	@NotEmpty(message = "emailAddress should not be Empty")
	@Size(max = 100)
	@Email(message = "enter valid email address")
	private String emailAddress;
	
	@NotNull(message = "contactNo should not be Null")
//	@Size(min = 10, max = 10, message = "contactNo should be 10 digits")
	@Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits")
	private Long contactNo;
	
	
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="dob")
	@NotNull(message = "dateOfBirth should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfbirth;
	
	@ManyToOne
	private Role role;
	
//	@ManyToMany(mappedBy = "consumers", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	private Set<Utility> utilitites;
	
	@NotNull(message = "password should not be Null")
	@Size(min = 8, message = "size should 8 characters or more")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="must contain one lower case, one upper case, one numeric and one symbol")
	@Column(name="password")
	private String password;
	
	
	public User() {
		super();
	}

		
	public User(int userId, String userName, String userType, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password=password;
		this.dateOfbirth = Calendar.getInstance().getTime();
		
	}
	
	public User(String userName, String userType, String password) {
		
		this.userName = userName;
		this.password=password;
		this.dateOfbirth = Calendar.getInstance().getTime();
		this.contactNo =54323L;
	}

	

	
	
	public User(int userId,
			@Size(min = 5, max = 8, message = "userId shoud be between 5 and 8 characters") @NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") String userName,
			@NotNull(message = "name should not be Null") @NotEmpty(message = "name shoudl not be Empty") @Size(max = 100) String name,
			@NotNull(message = "emailAddress should not be Null") @NotEmpty(message = "emailAddress should not be Empty") @Size(max = 100) @Email(message = "enter valid email address") String emailAddress,
			@NotNull(message = "contactNo should not be Null") @Digits(fraction = 0, integer = 10, message = "contactNo should be 10 digits") Long contactNo,
			String userType, @NotNull(message = "dateOfBirth should not be Null") Date dateOfbirth, Role role,
			@NotNull(message = "password should not be Null") @Size(min = 8, message = "size should 8 characters or more") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "must contain one lower case, one upper case, one numeric and one symbol") String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.emailAddress = emailAddress;
		this.contactNo = contactNo;
		this.userType = userType;
		this.dateOfbirth = dateOfbirth;
		this.role = role;
		this.password = password;
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


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public Date getDateOfbirth() {
		return dateOfbirth;
	}


	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Role getRoles() {
		return role;
	}

	public void setRole(Role roles) {
		this.role = roles;
	}
	
}
