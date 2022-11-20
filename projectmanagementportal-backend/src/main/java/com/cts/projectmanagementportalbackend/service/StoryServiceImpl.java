package com.cts.projectmanagementportalbackend.service;

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

		if (optionalStory!=null) {
			log.info(" inside getStoryById of StoryServiceImpl : " + storyId);
			return optionalStory;
		} else {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
	}

	/*
	 * Create Project Story
	 */
	@Override
	public Story saveStory(Story story){

		log.info(" inside saveStory of StoryServiceImpl : " + story.toString());

		Story optionalStory = storyRepository.findByStoryId(story.getStoryId());
//		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());
		User userAssignee = userRepository.findByName(story.getAssignee());
		
		if (optionalStory!=null) {
			log.warn("Story Id " + story.getStoryId() + " Already Exist");
			throw new IdAlreadyExistException("Story Id Already Exist");

		} else
		
		
		if (userAssignee == null) {

			String assigneNotFound = "user doesn't exist. please enter exist user...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else if (!userAssignee.getEmailAddress().equals(story.getAssigneeEmailId())) {
			String assigneNotFound = "assignee " + userAssignee.getName()
					+ "   email doesn't exist. please re-enter...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else {

//			ArrayList<String> projectAssignedUsers = projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers();
//			
//			if(projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers()!=null) {
//				
//			story.setStoryAssignedToUsers(projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers());
//			}
			log.info("saved story " + story.toString());
			return storyRepository.save(story);

		}
	}

	/*
	 * Update Story By Story ID
	 */
	@Override
	public Story updateStoryAdmin(String storyId, Story story)
			throws NoSuchElementExistException, InvalidUserIdOrPasswordException {

		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());

		User userAssignee = userRepository.findByName(story.getAssignee());

		Story optionalStory = storyRepository.findByStoryId(storyId);

		if (optionalStory==null) {

			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");

		} else if (userAssignee == null) {

			String assigneNotFound = "user doesn't exist. please enter exist user...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else if (!userAssignee.getEmailAddress().equals(story.getAssigneeEmailId())) {
			String assigneNotFound = "assignee " + userAssignee.getName()
					+ "   email doesn't match. please re-enter...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else {

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
	}

	/*
	 * Member Update
	 */
	@Override
	public Story updateStoryMember(String storyId, Story story){

		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());
		User userAssignee = userRepository.findByName(story.getAssignee());

		Story optionalStory = storyRepository.findByStoryId(storyId);

		if (optionalStory==null) {

			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");

		} else if (userAssignee == null) {

			String assigneNotFound = "user doesn't exist. please enter exist user...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else if (!userAssignee.getEmailAddress().equals(story.getAssigneeEmailId())) {
			String assigneNotFound = "assignee " + userAssignee.getName()
					+ "   email doesn't match. please re-enter...";
			log.warn(assigneNotFound);
			throw new InvalidUserIdOrPasswordException(assigneNotFound);

		} else {

			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
			Story storyData = optionalStory;
			storyData.setStoryDescription(story.getStoryDescription());
			storyData.setTargetDate(story.getTargetDate());
			storyData.setStatus(story.getStatus());
			storyData.setRemarks(story.getRemarks());
			return storyRepository.save(storyData);
		}
	}
	
	/*
	 * Delete Story By Story Id
	 */
	@Override
	public void deleteStoryById(String storyId) {

		log.info(" inside deleteStoryById of StoryServiceImpl");

		Story optionalProject = storyRepository.findByStoryId(storyId);
		if (optionalProject!=null) {
			log.info(" deleted Story with id : " + storyId);
			storyRepository.deleteById(storyId);
		} else {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}

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

			log.warn("project Id does'nt exist " + projectId);
			throw new NoSuchElementExistException("project Id doesn't exist");

		} else if (story == null) {

			log.warn("story Id does'nt exist " + storyId);
			throw new NoSuchElementExistException("story Id doesn't exist");
		}

		storySet = project.getStories();

		storySet.add(story);

		project.setStories(storySet);

		story.setProjectIdName(project.getProjectId());

		story.setStoryAssignedToUsers(
				projectRepository.findById(story.getProjectIdName()).get().getProjectAssignedToUsers());

		String msg = "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Servcie Impl " + msg);

		projectRepository.save(project);

	}


}
