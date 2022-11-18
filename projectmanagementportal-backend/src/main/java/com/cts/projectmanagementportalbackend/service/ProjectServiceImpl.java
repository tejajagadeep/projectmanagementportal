package com.cts.projectmanagementportalbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.TeamSizeExcedsException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryRepositry;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.security.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StoryRepositry storyRepository;
	
	@Autowired
	UserDetailsServiceImpl userDeatils;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Override
	public List<Project> getAllProjects() {
		log.info(" inside getAllProjects of ProjectServiceImpl");
		return projectRepository.findAll();
	}
	
	@Override
	public List<Project> getProjectsByProjectManagerName(String techLeadName) {

		log.info(" inside getProjectsByProjectName of ProjectServiceImpl : "+ techLeadName);
		
		
		return projectRepository.findByProjectManagerName(techLeadName);
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

	/*
	 * 
	 */
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
		

		int projectSizeParseInt  = Integer.parseInt(project.getTeamSize());
		
		project.setProjectOwner(user.getUserName());
		
		projectSet = user.getProjects();
		
		projectSet.add(project);
		
		user.setProjects(projectSet);
		
		
		
		String msg= "user with Id " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
//		projectRepository.save(project);
		userRepository.save(user);
		
	}
	
	/*
	 * 
	 */
	@Override
	public MessageResponse assignProjectToUser(String userName, String projectId) throws NoSuchElementExistException {
		
        Set<Project> projectSet = null;
		
		User user = userRepository.findByUserName(userName);
		
		Project project = projectRepository.findById(projectId).get();
		
		if (project == null) {
			
			log.warn("project Id does'nt exist " + userName);
			throw new NoSuchElementExistException("project Id doesn't exist");
			
		} else if (user==  null) {
			
			log.warn("User with Id does'nt exist " + userName);
			throw new NoSuchElementExistException("User with Id "+userName+" doesn't exist ");
		}
		

		int projectSizeParseInt  = Integer.parseInt(project.getTeamSize());
		
		boolean projectPMEqualsTL = project.getProjectManagerName().equals(project.getTechLeadName()); 
		boolean projectTLEqualsPO = userRepository.findByName(project.getProjectManagerName()).getUserName().equals(project.getProjectOwner());
		boolean projectPOEqualsPM = userRepository.findByName(project.getTechLeadName()).getUserName().equals(project.getProjectOwner());
			
		if (projectPMEqualsTL || projectTLEqualsPO || projectPOEqualsPM) {
			--projectSizeParseInt;
		} else
		
		if (projectPMEqualsTL && projectTLEqualsPO && projectPOEqualsPM) {
			--projectSizeParseInt;
		}
		
		--projectSizeParseInt;
		
		if (user.getName().equals(project.getProjectManagerName())) {
			
			throw new InvalidUserException("User already Assigned As Project Manager");
		} else if (user.getName().equals(project.getTechLeadName())) {
			
			throw new InvalidUserException("User already Assigned As Tech Lead");
		} else if (userName.equals(project.getProjectOwner())) {
			
			throw new InvalidUserException("User already Assigned As Project Owner");
		}
		
		projectSet = user.getProjects();
		
		projectSet.add(project);
		
		user.setProjects(projectSet);
		
		List<Story> storySetAssign =storyRepository.findByProjectIdName(projectId);
		
		ArrayList<String> dummy = new ArrayList<>();
		
		if(project.getProjectAssignedToUsers()!=null) {
			project.getProjectAssignedToUsers().forEach( assignProjectUser -> {
				
				if(assignProjectUser.contentEquals(userName)) {
					throw new InvalidUserException("User already Assigned.");
				} 
				
				dummy.add(assignProjectUser);
			});
		}
//		else if (project.getProjectAssignedToUsers().size()>projectSizeParseInt) {
//			throw new TeamSizeExcedsException("Cannot Assign User Please Update Team Size.");
//		}
//		System.out.println(project.getProjectAssignedToUsers().size());
//		System.out.println(project.getProjectAssignedToUsersSize());
		System.out.println(projectSizeParseInt);
		System.out.println(dummy.size());
		
		if (projectSizeParseInt<=dummy.size()) {
			
			throw new TeamSizeExcedsException("Cannot Assign User Please Update Team Size.");
		}
		
		
		project.addProjectAssignedToUsers(userName);
			
		storySetAssign.forEach(storyEach -> {
			
			storyEach.addStoryAssignedToUsers(userName);
		});
		
		log.info(" getProjectAssignedToUsers List: "+ project.getProjectAssignedToUsers());
		
		String msg= "User with Id : " + userName + " is assigned to project with Id : " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
//		projectRepository.save(project);
		userRepository.save(user);
		
		return new MessageResponse(msg);
	}
	
	
	
}
