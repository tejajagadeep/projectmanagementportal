package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;

public interface StoryService {

	List<Story> getAllStories();
	
	Story getStoryById(String storyId)  throws NoSuchElementExistException;

	Story saveStory(Story story)  throws IdAlreadyExistException, NoSuchElementExistException, InvalidUserIdOrPasswordException ;

	Story updateStoryAdmin(String storyId, Story story) throws NoSuchElementExistException, InvalidUserIdOrPasswordException;
	
	Story updateStoryMember(String storyId, Story story) throws NoSuchElementExistException, InvalidUserIdOrPasswordException;

	void deleteStoryById(String storyId)  throws NoSuchElementExistException;

	void assign(String projectId, String storyId)  throws NoSuchElementExistException;
	
}
