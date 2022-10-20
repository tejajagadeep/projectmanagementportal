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
	private Date assigneeDate;
	
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

	public Date getAssigneeDate() {
		return assigneeDate;
	}

	public void setAssigneeDate(Date assigneeDate) {
		this.assigneeDate = assigneeDate;
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
	
	
}
