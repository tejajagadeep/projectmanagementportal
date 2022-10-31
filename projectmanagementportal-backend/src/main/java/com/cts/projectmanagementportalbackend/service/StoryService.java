package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Story;

public interface StoryService {

	List<Story> getAllStories();
	
	Story getStoryById(String storyId)  throws NoSuchElementExistException;

	Story saveStory(Story story)  throws ElementAlreadyExistException, NoSuchElementExistException ;

	Story updateStory(@Valid Story story, String storyId) throws NoSuchElementExistException;

	void deleteStoryById(String storyId)  throws NoSuchElementExistException;

}
