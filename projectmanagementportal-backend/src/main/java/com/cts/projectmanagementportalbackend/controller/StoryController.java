package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.service.StoryService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/story")
public class StoryController {

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@Autowired
	StoryService storyService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getAllStories")
	public ResponseEntity<List<Story>> getAllStories(){
		
		log.info("inside getAllStories of Story Controller");
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getStoryById/{storyId}")
	public ResponseEntity<Story> getStoryById(@PathVariable String storyId) throws NoSuchElementExistException{
		
		log.info("inside getStoryById of Story Controller");
		return new ResponseEntity<>(storyService.getStoryById(storyId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/storyRegistration")
	public ResponseEntity<Story> saveStory(@Valid @RequestBody Story story)  throws IdAlreadyExistException, NoSuchElementExistException {
		
		log.info("inside storyRegistration of Story Controller");
		return new ResponseEntity<>(storyService.saveStory(story), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("updateStoryAdmin/{storyId}")
	public ResponseEntity<Story> updateStoryByIdAdmin(@PathVariable String storyId, @Valid @RequestBody Story story) throws NoSuchElementExistException{
		
		log.info("inside updateStoryById of Story Controller");
		return new ResponseEntity<>(storyService.updateStoryAdmin(storyId, story), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@PutMapping("updateStoryMember/{storyId}")
	public ResponseEntity<Story> updateStoryByIdMember(@PathVariable String storyId, @Valid @RequestBody Story story) throws NoSuchElementExistException{
		
		log.info("inside updateStoryById of Story Controller");
		return new ResponseEntity<>(storyService.updateStoryMember(storyId, story), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("updateStoryAssignAdmin/{projectId}/story/{storyId}")
	public String assign(@PathVariable String projectId, @PathVariable String storyId)  throws NoSuchElementExistException{
		storyService.assign(projectId, storyId);
		String msg= "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Controller "+msg);
		return msg;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/deleteStoryById/{storyId}")
	public ResponseEntity<List<Story>> deleteStoryById(@PathVariable String storyId) throws NoSuchElementExistException{
		
		log.info("inside deleteStoryById of Story Controller");
		storyService.deleteStoryById(storyId);
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}
	
}
