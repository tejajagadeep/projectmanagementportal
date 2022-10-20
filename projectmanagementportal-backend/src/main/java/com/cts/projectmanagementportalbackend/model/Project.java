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
	
}
