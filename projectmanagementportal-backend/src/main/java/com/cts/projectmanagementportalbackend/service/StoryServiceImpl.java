package com.cts.projectmanagementportalbackend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
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

	@Override
	public List<Story> getAllStories() {
		return storyReposiotry.findAll();
	}
	
	@Override
	public Story getStoryById(String storyId) throws NoSuchElementExistException {
		
		Optional<Story> optionalProject = storyReposiotry.findById(storyId);
		if(optionalProject.isPresent()) {
			return storyReposiotry.findById(storyId).get();
		} else {
			throw new NoSuchElementExistException("Story Id Doesn't Exist");
		}
	}

	@Override
	public Story saveStory(Story story) throws ElementAlreadyExistException, NoSuchElementExistException {

		Optional<Story> optionalStory = storyReposiotry.findById(story.getStoryId());
		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isPresent()) {

			throw new ElementAlreadyExistException("Story Id Already Exist");

		} else if (optionalProject.isEmpty()) {

			throw new NoSuchElementExistException("Project Id Doesn't Exist");

		} else {

			return storyReposiotry.save(story);

		}

	}

	@Override
	public Story updateStory(String storyId, Story story) throws NoSuchElementExistException {

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);
		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isEmpty()) {

			throw new NoSuchElementExistException("Story Id Doesn't Exist");

		} else if (optionalProject.isEmpty()) {

			throw new NoSuchElementExistException("Project Id Doesn't Exist");

		} else if (optionalProject.get().getProjectId()==story.getProjectId()) {
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
			throw new NoSuchElementExistException("This Story Id doesn't belong to this Project");
		}
	}

	@Override
	public void deleteStoryById(String storyId) throws NoSuchElementExistException {
		
		Optional<Story> optionalProject = storyReposiotry.findById(storyId);
		if(optionalProject.isPresent()) {
			storyReposiotry.deleteById(storyId);
		} else {
			throw new NoSuchElementExistException("Story Id Doesn't Exist");
		}
		
	}

	

}
