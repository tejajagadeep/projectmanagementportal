package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Getter // 9 , project_id is for
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Story {

	@Id
	@Size(max = 20)
	private String storyId;
	
//	@ManyToOne
//	@JoinColumn(name = "project_id")
//	@JsonIgnore
//	private Project project;
	
//	@Size(max = 20)
//	@NotEmpty(message = "projectId should not be Null")
//	@NotNull(message = "projectId should not be Null")
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	  @JoinColumn(name = "project_id")
//	  @OnDelete(action = OnDeleteAction.CASCADE)
//	  @JsonIgnore
//	private Project projectId;
	private String projectIdName;
	
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
	
	private String storyAssignedTo;
	
}
