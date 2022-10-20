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
}
