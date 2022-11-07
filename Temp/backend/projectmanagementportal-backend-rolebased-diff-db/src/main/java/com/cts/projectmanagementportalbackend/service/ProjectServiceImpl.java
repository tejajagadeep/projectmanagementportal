package com.cts.projectmanagementportalbackend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public List<Project> getProjectsByProjectManagerEmailId(String projectManagerEmailId) {
		List<Project> optionalProject = projectRepository.findByProjectManagerEmailId(projectManagerEmailId);
		
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
	public Project getProjectById(String projectId) throws NoSuchElementExistException {
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent()) {
			return projectRepository.findById(projectId).get();
		} else {
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
	}

	@Override
	public Project saveProject(Project project) throws IdAlreadyExistException {
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(project.getProjectId());
		if(optionalProject.isEmpty()) {
			return projectRepository.save(project);
		} else {
			throw new IdAlreadyExistException("Project with Id " + project.getProjectId() + "  already Exist");
		}
		
	}

	@Override
	public Project updateProjectById(String projectId, Project project)  throws NoSuchElementExistException{
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		
		if(optionalProject.isPresent()) {
			Project projectData = optionalProject.get();
			projectData.setProjectName(project.getProjectName());
			projectData.setProjectDescription(project.getProjectDescription());
			projectData.setTeamName(project.getTeamName());
			projectData.setTeamSize(project.getTeamSize());
			projectData.setProjectManagerName(project.getProjectManagerName());
			projectData.setProjectManagerEmailId(project.getProjectManagerEmailId());
			projectData.setTechLeadName(project.getTechLeadName());
			projectData.setTechLeadEmailId(project.getTechLeadEmailId());
			projectData.setProjectStartDate(project.getProjectStartDate());
			projectData.setProjectEndDate(project.getProjectEndDate());
			projectData.setTechStack(project.getTechStack());
			projectData.setStatus(project.getStatus());
			projectData.setRemarks(project.getRemarks());
			return projectRepository.save(projectData);
		} else {
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
	}

	@Override
	public void deleteProjectById(String projectId) throws NoSuchElementExistException {


		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent()) {
			projectRepository.deleteById(projectId);
		} else {
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
		
	}

	
	
	
	
	
}
