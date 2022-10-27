package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Project postProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	
	
	
	
}
