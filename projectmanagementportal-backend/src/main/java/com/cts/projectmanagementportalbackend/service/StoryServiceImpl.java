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
		
		Optional<Story> optionalProject = storyReposiotry.findById(storyId);
		if(optionalProject.isPresent()) {
			log.info(" inside getStoryById of StoryServiceImpl : "+ storyId);
			return storyReposiotry.findById(storyId).get();
		} else {
			log.info("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
	}

	@Override
	public Story saveStory(Story story) throws IdAlreadyExistException, NoSuchElementExistException {

		log.info(" inside saveStory of StoryServiceImpl : "+ story.toString());

		Optional<Story> optionalStory = storyReposiotry.findById(story.getStoryId());
//		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isPresent()) {
			log.info("Story Id "+story.getStoryId()+" Already Exist");
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
	public Story updateStory(String storyId, Story story) throws NoSuchElementExistException {

		log.info(" inside updateStory of StoryServiceImpl : "+ story.toString());

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);
		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isEmpty()) {
			log.info("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");

		} else if (optionalProject.isEmpty()) {
			log.info("Project with Id " + story.getProjectId() + " Doesn't Exist");
			throw new NoSuchElementExistException("Project with Id " + story.getProjectId() + " Doesn't Exist");

		} else if (optionalProject.get().getProjectId()==story.getProjectId()) {
			log.info(" updated story Id: "+storyId+ story.toString());
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
			log.info("This Story with Id " + storyId + " Id doesn't belong to this Project");
			throw new NoSuchElementExistException("This Story with Id " + storyId + " Id doesn't belong to this Project");
		}
	}

	@Override
	public void deleteStoryById(String storyId) throws NoSuchElementExistException {

		log.info(" inside deleteStoryById of StoryServiceImpl");
		
		Optional<Story> optionalProject = storyReposiotry.findById(storyId);
		if(optionalProject.isPresent()) {
			log.info(" deleted Story with id : "+ storyId);
			storyReposiotry.deleteById(storyId);
		} else {
			log.info("Story with Id " + storyId + " Doesn't Exist");
			throw new NoSuchElementExistException("Story with Id " + storyId + " Doesn't Exist");
		}
		
	}

	

}
