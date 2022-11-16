package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	List<Project> getProjectsByProjectOwner(String projectOwner);

	List<Project> getProjectsByProjectManagerName(String projectManagerName);
	
	List<Project> getProjectByAssignedTo(String projectAssignedTo);
	
	List<Project> getProjectsByTechLeadName(String techLeadName);

	List<Project> getProjectsByStatus(String status);
	
	Project getProjectById(String projectId) throws NoSuchElementExistException;

	Project saveProject(Project project) throws IdAlreadyExistException, InvalidUserIdOrPasswordException , NoSuchElementExistException ;

	Project updateProjectById(String projectId, Project project)  throws NoSuchElementExistException, InvalidUserIdOrPasswordException;

	void deleteProjectById(String projectId) throws NoSuchElementExistException;

	void assign(String userName, String projectId)  throws NoSuchElementExistException;

	void assignProjectToUser(String userName, String projectId) throws NoSuchElementExistException;


	
}
