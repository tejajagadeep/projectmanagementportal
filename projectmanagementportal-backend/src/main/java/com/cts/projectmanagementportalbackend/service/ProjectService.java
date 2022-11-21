package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	List<Project> getProjectsByProjectManagerName(String projectManagerName);
	
	List<Project> getProjectsByStatus(String status);
	
	Project getProjectById(String projectId);

	Project saveProject(Project project);

	Project updateProjectById(String projectId, Project project);

	void deleteProjectById(String projectId);

	void assign(String userName, String projectId);

	void assignProjectToUser(String userName, String projectId);


	
}
