package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	List<Project> getProjectsByProjectManagerEmailId(String projectManagerEmailId);
	
	List<Project> getProjectsByProjectName(String projectName);

	List<Project> getProjectsByProjectManagerName(String projectManagerName);

	List<Project> getProjectsByStatus(String status);
	
	Project getProjectById(String projectId) throws NoSuchElementExistException;

	Project saveProject(Project project) throws IdAlreadyExistException;

	Project updateProjectById(String projectId, Project project)  throws NoSuchElementExistException;

	void deleteProjectById(String projectId) throws NoSuchElementExistException;
	
}
