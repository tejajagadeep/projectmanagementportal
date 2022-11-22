package com.cts.projectmanagementportalbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cts.projectmanagementportalbackend.repository.StoryRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.security.UserDetailsServiceImpl;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StoryRepository storyRepository;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	/*
	 * Retrieve All Projects
	 */
	@Override
	public List<Project> getAllProjects() {
		log.info(" inside getAllProjects of ProjectServiceImpl");
		return projectRepository.findAll();
	}
	
	/*
	 * Getting Project By Project Manager
	 */
	@Override
	public List<Project> getProjectsByProjectManagerName(String name) {

		log.info(" inside getProjectsByProjectName of ProjectServiceImpl : "+ name);
		
		
		return projectRepository.findByProjectManagerName(name);
	}
	
	/*
	 * Getting Projects By Project Status. 
	 * 		Status: 'To-Do' or 'In-Progress' or 'Ready-For-Test' or 'Completed'
	 */
	@Override
	public List<Project> getProjectsByStatus(String status) {
		
		if (!status.equals("To-Do") && !status.equals("In-Progress") && !status.equals("Ready-For-Test") && !status.equals("Completed")) {
			throw new NoSuchElementExistException("Please give valid Status");
		}

		log.info(" inside getProjectsByStatus of ProjectServiceImpl : "+ status);
		
		
		return projectRepository.findByStatus(status);
	}
	
	/*
	 * Get Project By Project Id
	 */
	@Override
	public Project getProjectById(String projectId) {

		log.info(" inside getProjectById of ProjectServiceImpl : ");
		
		
		// TODO Auto-generated method stub
		Project optionalProject = projectRepository.findByProjectId(projectId);
		if(optionalProject==null) {
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		
			
		} 
		log.info("project with Id: "+ projectId);
		return optionalProject;
	}

	/*
	 * Creating Project
	 */
	@Override
	public Project saveProject(Project project) {

		log.info(" inside saveProject of ProjectServiceImpl : "+ project.toString());
		
		User userProjectManager = userRepository.findByName(project.getProjectManagerName());
		User userTechLead = userRepository.findByName(project.getTechLeadName());
		
		Project optionalProject = projectRepository.findByProjectId(project.getProjectId());
		
		if(optionalProject!=null) {
			log.warn("Project with Id " + project.getProjectId() + " Already Exist");
			throw new IdAlreadyExistException("Project with Id " + project.getProjectId() + " Already Exist");
		}  if (userProjectManager==null) {
			
			String projectManagerNotFound = "project Manager doesn't exist. please enter existing user";
			log.warn(projectManagerNotFound);
			throw new NoSuchElementExistException(projectManagerNotFound);
			
		} 
		if (userTechLead==null) {
			
			String techLeadNotFound = "Tech Lead doesn't exist. please enter existing user";
			log.warn(techLeadNotFound);
			throw new NoSuchElementExistException(techLeadNotFound);
		}
		if (optionalProject==null && userProjectManager!=null && userTechLead!=null) {
		if (!userProjectManager.getEmailAddress().equals(project.getProjectManagerEmailId())) {
			
			String projectManagerNotFound = "project Manager EmailId doesn't match with project manager: "+ userProjectManager.getName() +" . please re-enter ";
			log.warn(projectManagerNotFound);
			throw new InvalidUserException(projectManagerNotFound);
		
		}  if (!userTechLead.getEmailAddress().equals(project.getTechLeadEmailId())) {
			String techLeadNotFound = "Tech Lead Email Id doesn't match with Tech Lead Name. please re-enter...";
			log.warn(techLeadNotFound);
			throw new InvalidUserException(techLeadNotFound);
		
		} 
		}
			
			
//			assign(project.getProjectManagerName(), project.getProjectId());
			
			log.info("saved project "+ project.toString());
			return projectRepository.save(project);
		
		
		
	}
	
	/*
	 * Updating Project By Project Id
	 */

	@Override
	public Project updateProjectById(String projectId, Project project){

		log.info(" inside updateProjectById of ProjectServiceImpl : ");
		
		User userProjectManager = userRepository.findByName(project.getProjectManagerName());
		User userTechLead = userRepository.findByName(project.getTechLeadName());
		
		
		// TODO Auto-generated method stub
		Project optionalProject = projectRepository.findByProjectId(projectId);
		
		if(optionalProject==null) {
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");
		}  if (userProjectManager==null) {
			
			String projectManagerNotFound = "project Manager doesn't exist. please enter existing user";
			log.warn(projectManagerNotFound);
			throw new NoSuchElementExistException(projectManagerNotFound);
			
		} 
		if (userTechLead==null) {
			
			String techLeadNotFound = "Tech Lead doesn't exist. please enter existing user";
			log.warn(techLeadNotFound);
			throw new NoSuchElementExistException(techLeadNotFound);
		}
		if (optionalProject!=null && userProjectManager!=null && userTechLead!=null) {
		if (!userProjectManager.getEmailAddress().equals(project.getProjectManagerEmailId())) {
			
			String projectManagerNotFound = "project Manager EmailId doesn't match with project manager "+ userProjectManager.getName() +" please re-enter ";
			log.warn(projectManagerNotFound);
			throw new InvalidUserException(projectManagerNotFound);
		
		}  if (!userTechLead.getEmailAddress().equals(project.getTechLeadEmailId())) {
			String techLeadNotFound = "Tech Lead Email Id doesn't match please re-enter";
			log.warn(techLeadNotFound);
			throw new InvalidUserException(techLeadNotFound);
		
		} 
		}
		log.info("udpated project with id"+projectId + project.toString());
		Project projectData = optionalProject;
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

	/*
	 * Deleting Project By Project Id
	 */
	@Override
	public void deleteProjectById(String projectId) {

		log.info(" inside deleteProjectById of ProjectServiceImpl : ");
		
		Project optionalProject = projectRepository.findByProjectId(projectId);
		if(optionalProject==null) {
			log.warn("Project with Id " + projectId + " doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + projectId + " doesn't Exist");

			
		} 
		
		log.info("deleted project with Id :"+projectId);
		projectRepository.deleteById(projectId);
		
	}

	/*
	 * Assigning Project to That Creates the Projects
	 */
	@Override
	public void assign(String userName, String projectId){
		
        Set<Project> projectSet = null;
		
		User user = userRepository.findByUserName(userName);
		
		Project project = projectRepository.findByProjectId(projectId);
		
		
		if (project == null) {
			
			log.warn("project Id does'nt exist " + userName);
			throw new NoSuchElementExistException("project Id doesn't exist");
			
		} 
		
		if (user==  null) {
			
			log.warn("story Id does'nt exist " + userName);
			throw new NoSuchElementExistException("user doesn't exist " +userName);
		}
		

		project.setProjectOwner(user.getUserName());
		
		projectSet = user.getProjects();
		
		projectSet.add(project);
		
//		user.addProjects(project);
		
		user.setProjects(projectSet);
		
		
		
		String msg= "user with Id " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
//		projectRepository.save(project);
		userRepository.save(user);
		
	}
	
	/*
	 * Assigning Project to A user.
	 */
	@Override
	public void assignProjectToUser(String userName, String projectId) {
		
        Set<Project> projectSet = null;
		
		User user = userRepository.findByUserName(userName);
		
		Project project = projectRepository.findByProjectId(projectId);
		
		if (project == null) {
			
			log.warn("project Id does'nt exist " + projectId);
			throw new NoSuchElementExistException("project Id doesn't exist");
			
		} 
		
		if (user==  null) {
			
			log.warn("User with Id does'nt exist " + userName);
			throw new NoSuchElementExistException("User Id doesn't exist ");
		}
		

		int projectSizeParseInt  = Integer.parseInt(project.getTeamSize());
		
		boolean projectPMEqualsTL = project.getProjectManagerName().equals(project.getTechLeadName()); 
		boolean projectTLEqualsPO = userRepository.findByName(project.getProjectManagerName()).getUserName().equals(project.getProjectOwner());
		boolean projectPOEqualsPM = userRepository.findByName(project.getTechLeadName()).getUserName().equals(project.getProjectOwner());
			
		System.out.println(projectSizeParseInt);
		if (!projectPMEqualsTL && !projectTLEqualsPO && !projectPOEqualsPM) {
			projectSizeParseInt=projectSizeParseInt-2;
			System.out.println(projectSizeParseInt);
		} else
		
		if (!projectPMEqualsTL || !projectTLEqualsPO || !projectPOEqualsPM) {
			projectSizeParseInt=projectSizeParseInt-1;
			System.out.println(projectSizeParseInt);
		}
		projectSizeParseInt=projectSizeParseInt-1;
		System.out.println(projectSizeParseInt);
		if (user.getName().equals(project.getProjectManagerName())) {
			
			throw new IdAlreadyExistException("User already Assigned As Project Manager");
		}  if (user.getName().equals(project.getTechLeadName())) {
			
			throw new IdAlreadyExistException("User already Assigned As Tech Lead");
		}  if (userName.equals(project.getProjectOwner())) {
			
			throw new IdAlreadyExistException("User already Assigned As Project Owner");
		}
		
		projectSet = user.getProjects();
		
		projectSet.add(project);
		
		user.setProjects(projectSet);
		
		List<Story> storySetAssign =storyRepository.findByProjectIdName(projectId);
		
		ArrayList<String> dummy = new ArrayList<>();
		
		if(project.getProjectAssignedToUsers()!=null) {
			project.getProjectAssignedToUsers().stream().forEach( assignProjectUser -> {
				
				if(assignProjectUser.contentEquals(userName)) {
					throw new IdAlreadyExistException("User already Assigned.");
				} 
				
				dummy.add(assignProjectUser);
			});
		}
		System.out.println(dummy.size());
		System.out.println(projectSizeParseInt);
		if (dummy.size()>=projectSizeParseInt) {
			
			throw new TeamSizeExcedsException("Cannot Assign User Please Update Team Size.");
		}
		
		
		project.addProjectAssignedToUsers(userName);
			
//		storySetAssign.forEach(storyEach -> {
//			
//			storyEach.addStoryAssignedToUsers(userName);
//		});
		
//		user.setProjects(projectSet); 
		user.addProjects(project);
		
		log.info(" getProjectAssignedToUsers List: "+ project.getProjectAssignedToUsers());
		
		String msg= "User with Id : " + userName + " is assigned to project with Id : " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
		userRepository.save(user);
		
	}
	
	
	
}
