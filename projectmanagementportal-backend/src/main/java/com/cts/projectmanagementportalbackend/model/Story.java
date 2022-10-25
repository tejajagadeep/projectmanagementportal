package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
public class Story {

	@Id
	@Size(max = 20)
	private String storyId;
	
	@NotNull
	@Size(max = 20)
	private String projectId;
	
	@NotNull
	@Size(max = 50)
	private String storyTitle;
	
	@NotNull
	@Size(max = 100)
	private String storyDescription;
	
	@NotNull
	@Size(max = 30)
	private String assignee;
	
	@NotNull
	@Size(max = 50)
	private String assigneeEmailId;
	
	@NotNull
	private Date assignmentDate;
	
	@NotNull
	private Date targetDate;
	
	@NotNull
	@Size(max = 30)
	private String status;
	
	@Size(max = 100)
	private String remarks;

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Story(@Size(max = 20) String storyId, @NotNull @Size(max = 20) String projectId,
			@NotNull @Size(max = 50) String storyTitle, @NotNull @Size(max = 100) String storyDescription,
			@NotNull @Size(max = 30) String assignee, @NotNull @Size(max = 50) String assigneeEmailId,
			@NotNull Date assignmentDate, @NotNull Date targetDate, @NotNull @Size(max = 30) String status,
			@Size(max = 100) String remarks) {
		super();
		this.storyId = storyId;
		this.projectId = projectId;
		this.storyTitle = storyTitle;
		this.storyDescription = storyDescription;
		this.assignee = assignee;
		this.assigneeEmailId = assigneeEmailId;
		this.assignmentDate = assignmentDate;
		this.targetDate = targetDate;
		this.status = status;
		this.remarks = remarks;
	}

	public Story() {
		super();
	}
	
	
	
}
