package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.service.StoryService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	
	@PostMapping("/storyRegistration")
	public Story saveStory(@Valid @RequestBody Story story) {
		return storyService.saveStory(story);
	}
	
	
}
