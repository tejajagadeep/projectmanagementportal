package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.repository.StoryReposiotry;

@Service
public class StoryServiceImpl implements StoryService{
	
	@Autowired
	StoryReposiotry storyReposiotry;

	@Override
	public List<Story> getAllStories() {
		return storyReposiotry.findAll();
	}

}
