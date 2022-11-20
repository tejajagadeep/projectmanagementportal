package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Story;

public interface StoryService {

	List<Story> getAllStories();
	
	Story getStoryById(String storyId);

	Story saveStory(Story story) ;

	Story updateStoryAdmin(String storyId, Story story);
	
	Story updateStoryMember(String storyId, Story story);

	void deleteStoryById(String storyId) ;

	void assign(String projectId, String storyId) ;
	
//	MessageResponse assignStoryToUser(String userName, String storytId);
	
}
