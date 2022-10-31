package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
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
	public ResponseEntity<List<Story>> getAllStories(){
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}
	
	@GetMapping("/getStoryById/{storyId}")
	public ResponseEntity<Story> getStoryById(@PathVariable String storyId) throws NoSuchElementExistException{
		return new ResponseEntity<>(storyService.getStoryById(storyId), HttpStatus.OK);
	}
	
	@PostMapping("/storyRegistration")
	public ResponseEntity<Story> saveStory(@Valid @RequestBody Story story)  throws ElementAlreadyExistException, NoSuchElementExistException {
		return new ResponseEntity<>(storyService.saveStory(story), HttpStatus.CREATED);
	}
	
	@PutMapping("updateStory/{storyId}")
	public ResponseEntity<Story> updateStory(@PathVariable String storyId, @Valid @RequestBody Story story) throws NoSuchElementExistException{
		return new ResponseEntity<>(storyService.updateStory(storyId, story), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStoryById/{storyId}")
	public ResponseEntity<List<Story>> deleteStoryById(@PathVariable String storyId) throws NoSuchElementExistException{
		storyService.deleteStoryById(storyId);
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}
	
}
