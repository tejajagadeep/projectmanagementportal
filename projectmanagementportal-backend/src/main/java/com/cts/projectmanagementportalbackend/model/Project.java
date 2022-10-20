package com.cts.projectmanagementportalbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Table
@Entity
public class Project {

	@Id
	@Size(max = 20)
	private String projectId;
	
	@NotNull
	@Size(max = 30)
	private String projectName;
	
	@Size(max = 100)
	private String description;
	
	@NotNull
	@Size(max = 30)
	private String teamName;
	
	@NotNull
	@Size(max = 30)
	private String teamSize;
	
	@NotNull
	@Size(max = 30)
	private String projectManagerName;
	
	@NotNull
	@Size(max = 30)
	private String projectManagerEmailId;
	
	@NotNull
	@Size(max = 30)
	private String teamLeadName;
	
	@NotNull
	@Size(max = 50)
	private String teamLeadEmailId;
	
	@NotNull
	private Date projectStartDate;
	
	@NotNull
	private Date projectEndDate;
	
	@Size(max = 100)
	private String techStack;
	
	@NotNull
	@Size(max = 30)
	private String status;
	
	@Size(max = 100)
	private String remarks;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}

	public String getProjectManagerName() {
		return projectManagerName;
	}

	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}

	public String getProjectManagerEmailId() {
		return projectManagerEmailId;
	}

	public void setProjectManagerEmailId(String projectManagerEmailId) {
		this.projectManagerEmailId = projectManagerEmailId;
	}

	public String getTeamLeadName() {
		return teamLeadName;
	}

	public void setTeamLeadName(String teamLeadName) {
		this.teamLeadName = teamLeadName;
	}

	public String getTeamLeadEmailId() {
		return teamLeadEmailId;
	}

	public void setTeamLeadEmailId(String teamLeadEmailId) {
		this.teamLeadEmailId = teamLeadEmailId;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
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
