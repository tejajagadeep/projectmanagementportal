package com.cts.projectmanagementportalbackend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.ToString;

@Table
@Entity
@Getter // 14 , 15th story
@Setter
@NoArgsConstructor
@ToString
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

	private String projectOwner;
	private String projectAssignedTo;

	private ArrayList<String> projectAssignedToUsers;

	public void addProjectAssignedToUsers(String theProjectAssignedToUsers) {

		if (projectAssignedToUsers == null) {
			projectAssignedToUsers = new ArrayList<>();
//			stories = new HashSet<>();
		}

		projectAssignedToUsers.add(theProjectAssignedToUsers);

	}

//	@Getter(AccessLevel.NONE)
//	@Setter(AccessLevel.NONE)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Set<Story> stories;

	public void addStory(Story theStory) {

		if (stories == null) {
//			stories = new ArrayList<>();
			stories = new HashSet<>();
		}

		stories.add(theStory);

	}

//	private String[] projectAssignedTo;

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
