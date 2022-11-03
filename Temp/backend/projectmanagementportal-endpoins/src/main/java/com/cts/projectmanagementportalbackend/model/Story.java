package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Story {

	@Id
	@Size(max = 20)
	private String storyId;
	
	@NotNull(message = "projectId should not be Null")
	@Size(max = 20)
	@NotEmpty(message = "projectId should not be Null")
//	@ManyToOne
//	@JoinColumn(name = "project_id")
	private String projectId;
	
	@NotNull(message = "storyTitle should not be Null")
	@Size(max = 50)
	@NotEmpty(message = "storyTitle should not be Null")
	private String storyTitle;
	
	@NotNull(message = "storyDescription should not be Null")
	@Size(min = 100, message = "story description should contain minimium 100 characters")
	@NotEmpty(message = "storyDescription should not be Null")
	private String storyDescription;
	
	@NotNull(message = "assignee should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "assignee should not be Null")
	private String assignee;
	
	@NotNull(message = "assigneeEmailId should not be Null")
	@Size(max = 50)
	@Email
	@NotEmpty(message = "assigneeEmailId should not be Null")
	private String assigneeEmailId;
	
	@NotNull(message = "assignmentDate should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@NotEmpty(message = "assignmentDate should not be Null")
	private Date assignmentDate;
	
	@NotNull(message = "targetDate should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@NotEmpty(message = "targetDate should not be Null")
	private Date targetDate;
	
	@NotNull(message = "status should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "status should not be Null")
	private String status;
	
	@NotNull(message = "remarks should not be Null")
	@Size(max = 100)
	@NotEmpty(message = "remarks should not be empty")
	private String remarks;
	
	
}
