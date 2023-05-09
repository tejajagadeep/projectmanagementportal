package com.cts.projectmanagementportalbackend.service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	 * Retrieve A Story By Story ID
	 */
	@Override
	public Story getStoryById(String storyId){

		log.info(" inside getStoryById of StoryServiceImpl");

		Story optionalStory = storyRepository.findByStoryId(storyId);

		Optional.ofNullable(optionalStory).orElseThrow(()-> new NoSuchElementExistException("Story Id doesn't exists"));
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

		Optional.ofNullable(userAssignee).orElseThrow(()-> new NoSuchElementExistException("User mail doesn't exist. please enter exist user..."));

		if (!userAssignee.getName().equals(story.getAssignee())) {
			String assigneeNotFound = "Name doesn't match with Email Id. please enter valid user...";
			log.warn(assigneeNotFound);
			throw new InvalidUserException(assigneeNotFound);

		}
		log.info("saved story " + story);
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


		Optional.ofNullable(optionalStory).orElseThrow(()-> new NoSuchElementExistException("Story with Id: " + storyId + " Doesn't Exist."));
		Optional.ofNullable(userAssignee).orElseThrow(()-> new NoSuchElementExistException("User mail doesn't exist. please enter exist user..."));


		if (!userAssignee.getName().equals(story.getAssignee())) {
			String assigneeNotFound = "Name doesn't match with Email Id. please enter valid user...";
			log.warn(assigneeNotFound);
			throw new InvalidUserException(assigneeNotFound);

		}

		log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");

			return storyRepository.save(story);
		
	}

	/*
	 * Member Update
	 */
	/*
	 * Delete Story By Story ID
	 */
	@Override
	public void deleteStoryById(String storyId) {

		log.info(" inside deleteStoryById of StoryServiceImpl");

		Story optionalStory = storyRepository.findByStoryId(storyId);
		Optional.ofNullable(optionalStory).orElseThrow(()-> new NoSuchElementExistException("Story Id doesn't exists"));

		log.info(" deleted Story with id : " + storyId);
		storyRepository.deleteById(storyId);

	}

	/*
	 * Assign Story To Project // HashSet
	 */
	@Override
	public void assign(String projectId, String storyId){
		// TODO Auto-generated method stub

		Set<Story> storySet;

		Project project = projectRepository.findByProjectId(projectId);
		Story story = storyRepository.findByStoryId(storyId);
		Optional.ofNullable(project).orElseThrow(()-> new NoSuchElementExistException("Project Id doesn't exists"));
		Optional.ofNullable(story).orElseThrow(()-> new NoSuchElementExistException("Story Id doesn't exists"));



		storySet = project.getStories();

		storySet.add(story);

		project.setStories(storySet);

		story.setProjectIdName(project.getProjectId());

		String msg = "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Service Impl " + msg);

		projectRepository.save(project);

	}


	@Override
	public void assignStoryToUser(String userName, String storyId) {
//		Set<Story> storySet = null;

		Story story = storyRepository.findByStoryId(storyId);

		User user = userRepository.findByUserName(userName);
		Optional.ofNullable(user).orElseThrow(()-> new NoSuchElementExistException("User Id doesn't exists"));
		Optional.ofNullable(story).orElseThrow(()-> new NoSuchElementExistException("Story Id doesn't exists"));

		Project project = projectRepository.findByProjectId(story.getProjectIdName());

	
		if(story.getStoryAssignedToUsers()!=null) {
			if(story.getStoryAssignedToUsers().contains(userName)) {
				throw new IdAlreadyExistException("User Id Already Assigned For this story.");
			}
		}
		
		if (!user.getEmailAddress().equals(project.getProjectManagerEmailId())
				&& !user.getEmailAddress().equals(project.getTechLeadEmailId())
				&& !userName.equals(project.getProjectOwner())
				) {
			Optional.ofNullable(project.getProjectAssignedToUsers()).orElseThrow(()-> new NoSuchElementExistException("User not Part of the Project."));

			if (project.getProjectAssignedToUsers() != null) {
				if(!project.getProjectAssignedToUsers().contains(userName)){
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
