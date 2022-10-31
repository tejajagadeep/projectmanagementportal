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
	public Story updateStory(@Valid Story story, String storyId) throws NoSuchElementExistException {

		Optional<Story> optionalStory = storyReposiotry.findById(storyId);
		Optional<Project> optionalProject = projectRepository.findById(story.getProjectId());

		if (optionalStory.isEmpty()) {

			throw new NoSuchElementExistException("Story Id Doesn't Exist");

		} else if (optionalProject.isEmpty()) {

			throw new NoSuchElementExistException("Project Id Doesn't Exist");

		} else {

			return storyReposiotry.save(story);

		}
	}

}
