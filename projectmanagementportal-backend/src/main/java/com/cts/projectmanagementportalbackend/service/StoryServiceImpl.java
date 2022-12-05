package com.cts.projectmanagementportalbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@Service
public class StoryServiceImpl implements StoryService {

	@Autowired
	StoryRepository storyRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserRepository userRepository;

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	/*
	 * Retrieve All Stories
	 */
	@Override
	public List<Story> getAllStories() {

		log.info(" inside getAllStories of StoryServiceImpl");

		return storyRepository.findAll();
	}

	/*
	 * Retrieve A Story By Story Id
	 */
	@Override
	public Story getStoryById(String storyId){

		log.info(" inside getStoryById of StoryServiceImpl");

		Story optionalStory = storyRepository.findByStoryId(storyId);

		if (optionalStory==null) {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id: " + storyId + " doesn't Exist.");
		} 
		log.info(" inside getStoryById of StoryServiceImpl : " + storyId);
		return optionalStory;
	}

	/*
	 * Create Project Story
	 */
	@Override
	public Story saveStory(Story story){

		log.info(" inside saveStory of StoryServiceImpl : " + story.toString());

		Story optionalStory = storyRepository.findByStoryId(story.getStoryId());
//		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());
		User userAssignee = userRepository.findByEmailAddress(story.getAssigneeEmailId());
		
		if (optionalStory!=null) {
			log.warn("Story Id " + story.getStoryId() + " Already Exist.");
			throw new IdAlreadyExistException("Story Id Already Exist.");

		} 
		
		
		if (userAssignee == null) {

			String assigneeNotFound = "User mail doesn't exist. please enter exist user...";
			log.warn(assigneeNotFound);
			throw new NoSuchElementExistException(assigneeNotFound);
			

		} 
		if(optionalStory==null && userAssignee != null) {
		if (!userAssignee.getName().equals(story.getAssignee())) {
			String assigneeNotFound = "Name doesn't match with Email Id. please enter valid user...";
			log.warn(assigneeNotFound);
			throw new InvalidUserException(assigneeNotFound);

		} 
		}
//			ArrayList<String> projectAssignedUsers = projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers();
//			
//			if(projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers()!=null) {
//				
//			story.setStoryAssignedToUsers(projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers());
//			}
			log.info("saved story " + story.toString());
			return storyRepository.save(story);

		
	}

	/*
	 * Update Story By Story ID
	 */
	@Override
	public Story updateStoryAdmin(String storyId, Story story)
			throws NoSuchElementExistException, InvalidUserIdOrPasswordException {

		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());

		Story optionalStory = storyRepository.findByStoryId(storyId);
		
		User userAssignee = userRepository.findByEmailAddress(story.getAssigneeEmailId());

		

		if (optionalStory==null) {

			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id: " + storyId + " Doesn't Exist.");

		}  if (userAssignee == null) {

			String assigneeNotFound = "User mail doesn't exist. please enter exist user...";
			log.warn(assigneeNotFound);
			throw new NoSuchElementExistException(assigneeNotFound);
			

		} 
		if(optionalStory!=null && userAssignee != null) {
		if (!userAssignee.getName().equals(story.getAssignee())) {
			String assigneeNotFound = "Name doesn't match with Email Id. please enter valid user...";
			log.warn(assigneeNotFound);
			throw new InvalidUserException(assigneeNotFound);

		} 
		}

			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
			Story storyData = optionalStory;
			storyData.setStoryTitle(story.getStoryTitle());
			storyData.setStoryDescription(story.getStoryDescription());
			storyData.setAssignee(story.getAssignee());
			storyData.setAssigneeEmailId(story.getAssigneeEmailId());
			storyData.setAssignmentDate(story.getAssignmentDate());
			storyData.setTargetDate(story.getTargetDate());
			storyData.setStatus(story.getStatus());
			storyData.setRemarks(story.getRemarks());
			return storyRepository.save(storyData);
		
	}

	/*
	 * Member Update
	 */
//	@Override
//	public Story updateStoryMember(String storyId, Story story){
//
//		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());
//		User userAssignee = userRepository.findByName(story.getAssignee());
//
//		Story optionalStory = storyRepository.findByStoryId(storyId);
//
//		if (optionalStory==null) {
//
//			log.warn("Story with Id " + storyId + " Doesn't Exist");
//			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
//
//		} else if (userAssignee == null) {
//
//			String assigneNotFound = "user doesn't exist. please enter exist user...";
//			log.warn(assigneNotFound);
//			throw new InvalidUserIdOrPasswordException(assigneNotFound);
//
//		} else if (!userAssignee.getEmailAddress().equals(story.getAssigneeEmailId())) {
//			String assigneNotFound = "assignee " + userAssignee.getName()
//					+ "   email doesn't match. please re-enter...";
//			log.warn(assigneNotFound);
//			throw new InvalidUserIdOrPasswordException(assigneNotFound);
//
//		} else {
//
//			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
//			Story storyData = optionalStory;
//			storyData.setStoryDescription(story.getStoryDescription());
//			storyData.setTargetDate(story.getTargetDate());
//			storyData.setStatus(story.getStatus());
//			storyData.setRemarks(story.getRemarks());
//			return storyRepository.save(storyData);
//		}
//	}
//	
	/*
	 * Delete Story By Story Id
	 */
	@Override
	public void deleteStoryById(String storyId) {

		log.info(" inside deleteStoryById of StoryServiceImpl");

		Story optionalProject = storyRepository.findByStoryId(storyId);
		if (optionalProject==null) {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id: " + storyId + " doesn't Exist.");
	
			
		} 
		log.info(" deleted Story with id : " + storyId);
		storyRepository.deleteById(storyId);

	}

	/*
	 * Assign Story To Project // HashSet
	 */
	@Override
	public void assign(String projectId, String storyId){
		// TODO Auto-generated method stub

		Set<Story> storySet = null;

		Project project = projectRepository.findByProjectId(projectId);
		Story story = storyRepository.findByStoryId(storyId);

		if (project == null) {

			log.warn("project Id doesn't exist " + projectId);
			throw new NoSuchElementExistException("Project Id doesn't exist.");

		} 
		
		if (story == null) {

			log.warn("story Id doesn't exist " + storyId);
			throw new NoSuchElementExistException("Story Id doesn't exist.");
		}

		storySet = project.getStories();

		storySet.add(story);

		project.setStories(storySet);

		story.setProjectIdName(project.getProjectId());

//		story.setStoryAssignedToUsers(
//				projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers());

		String msg = "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Service Impl " + msg);

		projectRepository.save(project);

	}


	@Override
	public void assignStoryToUser(String userName, String storyId) {
//		Set<Story> storySet = null;

		Story story = storyRepository.findByStoryId(storyId);

		User user = userRepository.findByUserName(userName);

		if (user == null) {

			log.warn("User Id doesn't exist " + userName);
			throw new NoSuchElementExistException("User Id doesn't exist.");

		} 
		
		if (story == null) {

			log.warn("story Id doesn't exist " + storyId);
			throw new NoSuchElementExistException("Story Id doesn't exist.");
		}

		Project project = projectRepository.findByProjectId(story.getProjectIdName());

	
		if(story.getStoryAssignedToUsers()!=null) {
			if(story.getStoryAssignedToUsers().contains(userName)==true) {
				throw new IdAlreadyExistException("User Id Already Assigned For this story.");
			}
		}
		
		if (user.getEmailAddress().equals(project.getProjectManagerEmailId()) ==false
				&& user.getEmailAddress().equals(project.getTechLeadEmailId()) == false
				&& userName.equals(project.getProjectOwner()) == false
				) {
			if(project.getProjectAssignedToUsers() == null) {
			throw new NoSuchElementExistException("User not Part of the Project.");
			}
			if (project.getProjectAssignedToUsers() != null) {
				if(project.getProjectAssignedToUsers().contains(userName)==false){
					throw new NoSuchElementExistException("User not Part of the Project.");
				}
			}
				
				
		} 
		
		story.addStoryAssignedToUsers(userName);

		String msg = "story with Id " + storyId + " is assigned to User with Id " + userName;
		log.info("inside assign of Story Service Impl " + msg);

		storyRepository.save(story);

	}
}
