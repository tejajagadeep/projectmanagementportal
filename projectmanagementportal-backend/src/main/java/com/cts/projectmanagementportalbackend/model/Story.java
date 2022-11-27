package com.cts.projectmanagementportalbackend.model;

import java.util.ArrayList;
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
//@Getter // 9 , project_id is for
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
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
	
	@Size(max = 100)
	private String remarks;
	
	private ArrayList<String> storyAssignedToUsers;
	
	public void addStoryAssignedToUsers(String theStoryAssignedToUsers) {

		if (storyAssignedToUsers == null) {
			storyAssignedToUsers = new ArrayList<>();
//			stories = new HashSet<>();
		}

		storyAssignedToUsers.add(theStoryAssignedToUsers);

	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getProjectIdName() {
		return projectIdName;
	}

	public void setProjectIdName(String projectIdName) {
		this.projectIdName = projectIdName;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryDescription() {
		return storyDescription;
	}

	public void setStoryDescription(String storyDescription) {
		this.storyDescription = storyDescription;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssigneeEmailId() {
		return assigneeEmailId;
	}

	public void setAssigneeEmailId(String assigneeEmailId) {
		this.assigneeEmailId = assigneeEmailId;
	}

	public Date getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ArrayList<String> getStoryAssignedToUsers() {
		return storyAssignedToUsers;
	}

	public void setStoryAssignedToUsers(ArrayList<String> storyAssignedToUsers) {
		this.storyAssignedToUsers = storyAssignedToUsers;
	}

	public Story(@Size(max = 20) String storyId, String projectIdName,
			@NotNull(message = "storyTitle should not be Null") @Size(max = 50) @NotEmpty(message = "storyTitle should not be Null") String storyTitle,
			@NotNull(message = "storyDescription should not be Null") @Size(min = 100, message = "story description should contain minimium 100 characters") @NotEmpty(message = "storyDescription should not be Null") String storyDescription,
			@NotNull(message = "assignee should not be Null") @Size(max = 30) @NotEmpty(message = "assignee should not be Null") String assignee,
			@NotNull(message = "assigneeEmailId should not be Null") @Size(max = 50) @Email @NotEmpty(message = "assigneeEmailId should not be Null") String assigneeEmailId,
			@NotNull(message = "assignmentDate should not be Null") Date assignmentDate,
			@NotNull(message = "targetDate should not be Null") Date targetDate,
			@NotNull(message = "status should not be Null") @Size(max = 30) @NotEmpty(message = "status should not be Null") String status,
			@NotNull(message = "remarks should not be Null") @Size(max = 100) @NotEmpty(message = "remarks should not be empty") String remarks,
			ArrayList<String> storyAssignedToUsers) {
		super();
		this.storyId = storyId;
		this.projectIdName = projectIdName;
		this.storyTitle = storyTitle;
		this.storyDescription = storyDescription;
		this.assignee = assignee;
		this.assigneeEmailId = assigneeEmailId;
		this.assignmentDate = assignmentDate;
		this.targetDate = targetDate;
		this.status = status;
		this.remarks = remarks;
		this.storyAssignedToUsers = storyAssignedToUsers;
	}

	public Story() {
		super();
	}

	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", projectIdName=" + projectIdName + ", storyTitle=" + storyTitle
				+ ", storyDescription=" + storyDescription + ", assignee=" + assignee + ", assigneeEmailId="
				+ assigneeEmailId + ", assignmentDate=" + assignmentDate + ", targetDate=" + targetDate + ", status="
				+ status + ", remarks=" + remarks + ", storyAssignedToUsers=" + storyAssignedToUsers + "]";
	}

	public Story(@Size(max = 20) String storyId, String projectIdName,
			@NotNull(message = "storyTitle should not be Null") @Size(max = 50) @NotEmpty(message = "storyTitle should not be Null") String storyTitle,
			@NotNull(message = "storyDescription should not be Null") @Size(min = 100, message = "story description should contain minimium 100 characters") @NotEmpty(message = "storyDescription should not be Null") String storyDescription,
			@NotNull(message = "assignee should not be Null") @Size(max = 30) @NotEmpty(message = "assignee should not be Null") String assignee,
			@NotNull(message = "assigneeEmailId should not be Null") @Size(max = 50) @Email @NotEmpty(message = "assigneeEmailId should not be Null") String assigneeEmailId,
			@NotNull(message = "assignmentDate should not be Null") Date assignmentDate,
			@NotNull(message = "targetDate should not be Null") Date targetDate,
			@NotNull(message = "status should not be Null") @Size(max = 30) @NotEmpty(message = "status should not be Null") String status,
			@NotNull(message = "remarks should not be Null") @Size(max = 100) @NotEmpty(message = "remarks should not be empty") String remarks) {
		super();
		this.storyId = storyId;
		this.projectIdName = projectIdName;
		this.storyTitle = storyTitle;
		this.storyDescription = storyDescription;
		this.assignee = assignee;
		this.assigneeEmailId = assigneeEmailId;
		this.assignmentDate = assignmentDate;
		this.targetDate = targetDate;
		this.status = status;
		this.remarks = remarks;
	}
	
	
	
}
