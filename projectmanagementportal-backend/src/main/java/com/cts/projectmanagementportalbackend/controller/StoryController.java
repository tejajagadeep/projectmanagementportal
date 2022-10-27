package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.service.StoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/story")
public class StoryController {

	
	@Autowired
	StoryService storyService;
	
	@GetMapping("/getAllStories")
	public List<Story> getAllStories(){
		return storyService.getAllStories();
	}
}
