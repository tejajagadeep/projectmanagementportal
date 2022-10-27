package com.cts.projectmanagementportalbackend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

	@Id
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

//	@OneToMany(targetEntity = Story.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = )
//	private List<Story> story;
	
	
	
}
