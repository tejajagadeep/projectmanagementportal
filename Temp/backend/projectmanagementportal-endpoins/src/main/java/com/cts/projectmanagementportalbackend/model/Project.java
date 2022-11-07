package com.cts.projectmanagementportalbackend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table
@Entity
public class Project {

	@Id
	@NotNull(message = "projectId should not be Null")
	@Size(max = 20)
	private String projectId;
	
	@NotNull(message = "projectName should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "projectName should not be empty")
	private String projectName;
	
	@NotNull(message = "projectDescription should not be Null")
	@Size(min = 100, message = "project description should contain minimium 100 characters")
	@NotEmpty(message = "project Description should not be empty")
	private String projectDescription;
	
	@NotNull(message = "teamName should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "teamName should not be empty")
	private String teamName;
	
	@NotNull(message = "teamSize should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "teamSize should not be empty")
	private String teamSize;
	
	@NotNull(message = "projectManagerName should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "projectManagerName should not be empty")
	private String projectManagerName;
	
	@NotNull(message = "projectManagerEmailId should not be Null")
	@Size(max = 30)
	@Email
	@NotEmpty(message = "projectManagerEmailId should not be empty")
	private String projectManagerEmailId;
	
	@NotNull(message = "techLeadName should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "techLeadName should not be empty")
	private String techLeadName;
	
	@NotNull(message = "techLeadEmailId should not be Null")
	@Size(max = 50)
	@Email
	@NotEmpty(message = "techLeadEmailId should not be empty")
	private String techLeadEmailId;
	
	@NotNull(message = "projectStartDate should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@NotEmpty(message = "projectStartDate should not be empty")
	private Date projectStartDate;
	
	@NotNull(message = "projectEndDate should not be Null")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	@NotEmpty(message = "projectEndDate should not be empty")
	private Date projectEndDate;
	
	@NotNull(message = "techStack should not be Null")
	@Size(max = 100)
	@NotEmpty(message = "techStack should not be empty")
	private String techStack;
	
	@NotNull(message = "status should not be Null")
	@Size(max = 30)
	@NotEmpty(message = "status should not be empty")
	private String status;
	
	@NotNull(message = "remarks should not be Null")
	@Size(max = 100)
	@NotEmpty(message = "remarks should not be empty")
	private String remarks;

//	@Getter(AccessLevel.NONE)
//	@Setter(AccessLevel.NONE)
//	@OneToMany(mappedBy = "project")
//	private List<Story> stories = new ArrayList<>();
	
	

	public Project(@NotNull(message = "projectId should not be Null") @Size(max = 20) String projectId,
			@NotNull(message = "projectName should not be Null") @Size(max = 30) @NotEmpty(message = "projectName should not be empty") String projectName,
			@NotNull(message = "projectDescription should not be Null") @Size(min = 100, message = "project description should contain minimium 100 characters") @NotEmpty(message = "project Description should not be empty") String projectDescription,
			@NotNull(message = "teamName should not be Null") @Size(max = 30) @NotEmpty(message = "teamName should not be empty") String teamName,
			@NotNull(message = "teamSize should not be Null") @Size(max = 30) @NotEmpty(message = "teamSize should not be empty") String teamSize,
			@NotNull(message = "projectManagerName should not be Null") @Size(max = 30) @NotEmpty(message = "projectManagerName should not be empty") String projectManagerName,
			@NotNull(message = "projectManagerEmailId should not be Null") @Size(max = 30) @Email @NotEmpty(message = "projectManagerEmailId should not be empty") String projectManagerEmailId,
			@NotNull(message = "techLeadName should not be Null") @Size(max = 30) @NotEmpty(message = "techLeadName should not be empty") String techLeadName,
			@NotNull(message = "techLeadEmailId should not be Null") @Size(max = 50) @Email @NotEmpty(message = "techLeadEmailId should not be empty") String techLeadEmailId,
			@NotNull(message = "projectStartDate should not be Null") Date projectStartDate,
			@NotNull(message = "projectEndDate should not be Null") Date projectEndDate,
			@NotNull(message = "techStack should not be Null") @Size(max = 100) @NotEmpty(message = "techStack should not be empty") String techStack,
			@NotNull(message = "status should not be Null") @Size(max = 30) @NotEmpty(message = "status should not be empty") String status,
			@NotNull(message = "remarks should not be Null") @Size(max = 100) @NotEmpty(message = "remarks should not be empty") String remarks) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.teamName = teamName;
		this.teamSize = teamSize;
		this.projectManagerName = projectManagerName;
		this.projectManagerEmailId = projectManagerEmailId;
		this.techLeadName = techLeadName;
		this.techLeadEmailId = techLeadEmailId;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.techStack = techStack;
		this.status = status;
		this.remarks = remarks;
	}

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

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
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

	public String getTechLeadName() {
		return techLeadName;
	}

	public void setTechLeadName(String techLeadName) {
		this.techLeadName = techLeadName;
	}

	public String getTechLeadEmailId() {
		return techLeadEmailId;
	}

	public void setTechLeadEmailId(String techLeadEmailId) {
		this.techLeadEmailId = techLeadEmailId;
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

	public Project() {
		super();
	}

	

//
//	public List<Story> getStories() {
//		return stories;
//	}
//
//
//
//	public void addStory(Story story) {
//		this.stories.add(story);
//	}
//	
//	public void removeStory(Story story) {
//		this.stories.remove(story);
//	}
//	
}
