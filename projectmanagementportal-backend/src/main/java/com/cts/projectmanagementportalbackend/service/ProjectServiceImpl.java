package com.cts.projectmanagementportalbackend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public List<Project> getProjectsByProjectManagerEmailId(String projectManagerEmailId) {
		return projectRepository.findByProjectManagerEmailId(projectManagerEmailId);
	}

	@Override
	public List<Project> getProjectsByProjectName(String projectName) {
		return projectRepository.findByProjectName(projectName);
	}

	@Override
	public List<Project> getProjectsByProjectManagerName(String projectManagerName) {
		return projectRepository.findByProjectManagerName(projectManagerName);
	}

	@Override
	public List<Project> getProjectsByStatus(String status) {
		return projectRepository.findByStatus(status);
	}

	@Override
	public Project saveProject(Project project) throws ElementAlreadyExistException {
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(project.getProjectId());
		if(optionalProject.isEmpty()) {
			return projectRepository.save(project);
		} else {
			throw new ElementAlreadyExistException("Project Id already Exist");
		}
		
	}

	@Override
	public Project updateProject(@Valid Project project, String projectId)  throws NoSuchElementExistException{
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		
		if(optionalProject.isPresent()) {
			return projectRepository.save(project);
		} else {
			throw new NoSuchElementExistException("Project Id Doesn't Exist");
		}
	}

	
	
	
	
}
