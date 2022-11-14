package com.cts.projectmanagementportalbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
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
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
	}

	@Override
	public Project saveProject(Project project) throws IdAlreadyExistException, InvalidUserIdOrPasswordException, NoSuchElementExistException {

		log.info(" inside saveProject of ProjectServiceImpl : "+ project.toString());
		
		User userProjectManager = userRepository.findByName(project.getProjectManagerName());
		User userTechLead = userRepository.findByName(project.getTechLeadName());
		
		Optional<Project> optionalProject = projectRepository.findById(project.getProjectId());
		
		if (optionalProject.isPresent()) {
			
			log.warn("Project with Id " + project.getProjectId() + "  already Exist");
			throw new IdAlreadyExistException("Project with Id " + project.getProjectId() + "  already Exist");
			
			
		} else if (userProjectManager==null) {
			
			String projectManagerNotFound = "project Manager doesn't exist. please enter existing user...";
			log.warn(projectManagerNotFound);
			throw new InvalidUserIdOrPasswordException(projectManagerNotFound);
			
		} else if (!userProjectManager.getEmailAddress().equals(project.getProjectManagerEmailId())) {
			String projectManagerNotFound = "project Manager EmailId doesn't match with project manager "+ userProjectManager.getName() +" please re-enter... ";
			log.warn(projectManagerNotFound);
			throw new InvalidUserIdOrPasswordException(projectManagerNotFound);
		
		} else if (userTechLead==null) {
			
			String techLeadNotFound = "Tech Lead doesn't exist. please enter existing user...";
			log.warn(techLeadNotFound);
			throw new InvalidUserIdOrPasswordException(techLeadNotFound);
		
		} else if (!userTechLead.getEmailAddress().equals(project.getTechLeadEmailId())) {
			String techLeadNotFound = "Tech Lead Email Id doesn't match please re-enter...";
			log.warn(techLeadNotFound);
			throw new InvalidUserIdOrPasswordException(techLeadNotFound);
			
		} else {
			
			
//			assign(project.getProjectManagerName(), project.getProjectId());
			
			log.info("saved project "+ project.toString());
			return projectRepository.save(project);
		}
		
		
		
	}

	@Override
	public Project updateProjectById(String projectId, Project project)  throws NoSuchElementExistException, InvalidUserIdOrPasswordException{

		log.info(" inside updateProjectById of ProjectServiceImpl : ");
		
		User userProjectManager = userRepository.findByName(project.getProjectManagerName());
		User userTechLead = userRepository.findByName(project.getTechLeadName());
		
		
		// TODO Auto-generated method stub
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		
		if(optionalProject.isEmpty()) {
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		} else if (userProjectManager==null) {
			
			String projectManagerNotFound = "project Manager doesn't exist. please enter existing user";
			log.warn(projectManagerNotFound);
			throw new InvalidUserIdOrPasswordException(projectManagerNotFound);
			
		} else if (!userProjectManager.getEmailAddress().equals(project.getProjectManagerEmailId())) {
			
			String projectManagerNotFound = "project Manager EmailId doesn't match with project manager "+ userProjectManager.getName() +" please re-enter ";
			log.warn(projectManagerNotFound);
			throw new InvalidUserIdOrPasswordException(projectManagerNotFound);
		
		} else if (userTechLead==null) {
			
			String techLeadNotFound = "Tech Lead doesn't exist. please enter existing user";
			log.warn(techLeadNotFound);
			throw new InvalidUserIdOrPasswordException(techLeadNotFound);
		
		} else if (!userTechLead.getEmailAddress().equals(project.getTechLeadEmailId())) {
			String techLeadNotFound = "Tech Lead Email Id doesn't match please re-enter";
			log.warn(techLeadNotFound);
			throw new InvalidUserIdOrPasswordException(techLeadNotFound);
		
		} else {
			
			
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
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}
		
	}

	@Override
	public void assign(String userName, String projectId) throws NoSuchElementExistException {
		
        Set<Project> projectSet = null;
		
		User user = userRepository.findByUserName(userName);
		
		Project project = projectRepository.findById(projectId).get();
		
		if (project == null) {
			
			log.warn("project Id does'nt exist " + userName);
			throw new NoSuchElementExistException("project Id doesn't exist");
			
		} else if (user==  null) {
			
			log.warn("story Id does'nt exist " + userName);
			throw new NoSuchElementExistException("user doesn't exist " +userName);
		}
		
		projectSet = user.getProjects();
		
		projectSet.add(project);
		
		user.setProjects(projectSet);
		
		
		String msg= "user with Id " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
//		projectRepository.save(project);
		userRepository.save(user);
		
	}

	
	
	
	
	
}
