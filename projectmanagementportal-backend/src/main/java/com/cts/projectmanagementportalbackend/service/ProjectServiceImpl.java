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
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Override
	public List<Project> getAllProjects() {
		log.info(" inside getAllProjects of ProjectServiceImpl");
		return projectRepository.findAll();
	}
	
	@Override
	public List<Project> getProjectsByProjectManagerEmailId(String projectManagerEmailId) {

		log.info(" inside getProjectsByProjectManagerEmailId of ProjectServiceImpl : "+ projectManagerEmailId);
		
		List<Project> optionalProject = projectRepository.findByProjectManagerEmailId(projectManagerEmailId);
		
		return projectRepository.findByProjectManagerEmailId(projectManagerEmailId);
	}

	@Override
	public List<Project> getProjectsByProjectName(String projectName) {

		log.info(" inside getProjectsByProjectName of ProjectServiceImpl : "+ projectName);
		
		
		return projectRepository.findByProjectName(projectName);
	}

	@Override
	public List<Project> getProjectsByProjectManagerName(String projectManagerName) {

		log.info(" inside getProjectsByProjectManagerName of ProjectServiceImpl : "+ projectManagerName);
		
		
		return projectRepository.findByProjectManagerName(projectManagerName);
	}

	@Override
	public List<Project> getProjectsByStatus(String status) {

		log.info(" inside getProjectsByStatus of ProjectServiceImpl : "+ status);
		
		
		return projectRepository.findByStatus(status);
	}
	
	@Override
	public Project getProjectById(String projectId) throws NoSuchElementExistException {

		log.info(" inside getProjectById of ProjectServiceImpl : ");
		
		
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent()) {
			log.info("project with Id: "+ projectId);
			return projectRepository.findById(projectId).get();
		} else {
			log.info("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
	}

	@Override
	public Project saveProject(Project project) throws IdAlreadyExistException {

		log.info(" inside saveProject of ProjectServiceImpl : "+ project.toString());
		
		
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(project.getProjectId());
		if(optionalProject.isEmpty()) {
			log.info("saved project "+ project.toString());
			return projectRepository.save(project);
		} else {
			log.info("Project with Id " + project.getProjectId() + "  already Exist");
			throw new IdAlreadyExistException("Project with Id " + project.getProjectId() + "  already Exist");
		}
		
	}

	@Override
	public Project updateProjectById(String projectId, Project project)  throws NoSuchElementExistException{

		log.info(" inside updateProjectById of ProjectServiceImpl : ");
		
		
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		
		if(optionalProject.isPresent()) {
			log.info("udpated project with id"+projectId + project.toString());
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
			log.info("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
	}

	@Override
	public void deleteProjectById(String projectId) throws NoSuchElementExistException {

		log.info(" inside deleteProjectById of ProjectServiceImpl : ");
		
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent()) {
			log.info("deleted project with Id :"+projectId);
			projectRepository.deleteById(projectId);
		} else {
			log.info("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
		
	}

	
	
	
	
	
}
