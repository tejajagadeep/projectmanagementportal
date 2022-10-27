package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	List<Project> getProjectsByProjectManagerEmailId(String projectManagerEmailId);
	
	List<Project> getProjectsByProjectName(String projectName);

	List<Project> getProjectsByProjectManagerName(String projectManagerName);

	List<Project> getProjectsByStatus(String status);

	Project postProject(Project project);

	
}
