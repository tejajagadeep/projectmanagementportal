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
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryReposiotry;

@Service
public class StoryServiceImpl implements StoryService {

	@Autowired
	StoryReposiotry storyReposiotry;

	@Autowired
	ProjectRepository projectRepository;

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Override
	public List<Story> getAllStories() {

		log.info(" inside getAllStories of StoryServiceImpl");

		return storyReposiotry.findAll();
	}

	@Override
	public Story getStoryById(String storyId) throws NoSuchElementExistException {

		log.info(" inside getStoryById of StoryServiceImpl");

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);

		if (optionalStory.isPresent()) {
			log.info(" inside getStoryById of StoryServiceImpl : " + storyId);
			return optionalStory.get();
		} else {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
	}

	@Override
	public Story saveStory(Story story) throws IdAlreadyExistException, NoSuchElementExistException {

		log.info(" inside saveStory of StoryServiceImpl : " + story.toString());

		Optional<Story> optionalStory = storyReposiotry.findById(story.getStoryId());
//		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isPresent()) {
			log.warn("Story Id " + story.getStoryId() + " Already Exist");
			throw new IdAlreadyExistException("Story Id Already Exist");

//		} else if (optionalProject.isEmpty()) {
//
//			throw new NoSuchElementExistException("Project with Id " + story.getProjectId() + " Doesn't Exist");

		} else {
			log.info("saved story " + story.toString());
			return storyReposiotry.save(story);

		}

	}

	@Override
	public Story updateStoryAdmin(String storyId, Story story) throws NoSuchElementExistException {

		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);

		if (optionalStory.isPresent()) {
			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
			Story storyData = optionalStory.get();
			storyData.setStoryTitle(story.getStoryTitle());
			storyData.setStoryDescription(story.getStoryDescription());
			storyData.setAssignee(story.getAssignee());
			storyData.setAssigneeEmailId(story.getAssigneeEmailId());
			storyData.setAssignmentDate(story.getAssignmentDate());
			storyData.setTargetDate(story.getTargetDate());
			storyData.setStatus(story.getStatus());
			storyData.setRemarks(story.getRemarks());
			return storyReposiotry.save(storyData);

		} else {

			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
	}

	@Override
	public Story updateStoryMember(String storyId, Story story) throws NoSuchElementExistException {

		log.info(" inside updateStory of StoryServiceImpl : " + story.toString());

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);

		if (optionalStory.isPresent()) {
			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
			Story storyData = optionalStory.get();
			storyData.setStoryTitle(story.getStoryTitle());
			storyData.setStoryDescription(story.getStoryDescription());
			storyData.setTargetDate(story.getTargetDate());
			storyData.setStatus(story.getStatus());
			storyData.setRemarks(story.getRemarks());
			return storyReposiotry.save(storyData);
			

		} else {

			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
	}

	@Override
	public void deleteStoryById(String storyId) throws NoSuchElementExistException {

		log.info(" inside deleteStoryById of StoryServiceImpl");

		Optional<Story> optionalProject = storyReposiotry.findById(storyId);
		if (optionalProject.isPresent()) {
			log.info(" deleted Story with id : " + storyId);
			storyReposiotry.deleteById(storyId);
		} else {
			log.warn("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}

	}

	@Override
	public void assign(String projectId, String storyId) throws NoSuchElementExistException {
		// TODO Auto-generated method stub
		
		Set<Story> storySet = null;
		
		Project project = projectRepository.findById(projectId).get();
		Story story = storyReposiotry.findById(storyId).get();
		
		if (project == null) {
			
			log.warn("project Id does'nt exist " + projectId);
			throw new NoSuchElementExistException("project Id doesn't exist");
			
		} else if (story==  null) {
			
			log.warn("story Id does'nt exist " + storyId);
			throw new NoSuchElementExistException("story Id doesn't exist");
		}
		
		
		storySet = project.getStories();
		
		storySet.add(story);
		
		project.setStories(storySet);
		
		
		String msg= "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Servcie Impl "+msg);
		
		projectRepository.save(project);
		
	}

}
