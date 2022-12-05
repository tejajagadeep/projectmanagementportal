package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.service.StoryService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/story")
public class StoryController {

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@Autowired
	StoryService storyService;

	@Operation(summary = "Retrieve All Stories", description = "Retrieve all the stories in the data base." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("")
	public ResponseEntity<List<Story>> getAllStories(){
		
		log.info("inside getAllStories of Story Controller");
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}

	@Operation(summary = "Retrieve Story", description = "fetch a story details by story Id from the data base." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/storyId/{storyId}")
	public ResponseEntity<Story> getStoryById(@Parameter(description = "Enter Story Id") @PathVariable String storyId){
		
		log.info("inside getStoryById of Story Controller");
		return new ResponseEntity<>(storyService.getStoryById(storyId), HttpStatus.OK);
	}

	@Operation(summary = "Save Story", description = "User gives story details which are story in the data base. Access by only ADMIN" ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("")
	public ResponseEntity<Story> saveStory(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Enter Story Details") @Valid @RequestBody Story story) {
		
		log.info("inside storyRegistration of Story Controller");
		return new ResponseEntity<>(storyService.saveStory(story), HttpStatus.CREATED);
	}

	@Operation(summary = "Update Story", description = "fetch the details of a story by story Id and update the story and save it to the database." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@PutMapping("/storyId/{storyId}")
	public ResponseEntity<Story> updateStoryByIdAdmin(@Parameter(description = "Enter Story Id") @PathVariable String storyId,@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Enter Story Details")  @Valid @RequestBody Story story){
		
		log.info("inside updateStoryById of Story Controller");
		return new ResponseEntity<>(storyService.updateStoryAdmin(storyId, story), HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_MEMBER')")
//	@PutMapping("updateStoryMember/{storyId}")
//	public ResponseEntity<Story> updateStoryByIdMember(@PathVariable String storyId, @Valid @RequestBody Story story){
//		
//		log.info("inside updateStoryById of Story Controller");
//		return new ResponseEntity<>(storyService.updateStoryMember(storyId, story), HttpStatus.OK);
//	}

	@Operation(summary = "Foreign key Story", description = "assigning the story to a project. Making the project Id as a foreign key. Access by only admin." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("storyAssignAdmin/{projectId}/story/{storyId}")
	public ResponseEntity<MessageResponse> assign(@Parameter(description = "Enter Project Id") @PathVariable String projectId,@Parameter(description = "Enter Story Id")  @PathVariable String storyId) {
		storyService.assign(projectId, storyId);
		String msg= "story with Id " + storyId + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(msg), HttpStatus.OK);
	}

	@Operation(summary = "Assign a Story to User.", description = "Assigning a story to a user." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/assignStoryToUsers/{userName}/story/{storyId}")
	public ResponseEntity<MessageResponse> assignStoryToUsers(@Parameter(description = "Enter User Id") @PathVariable String userName,@Parameter(description = "Enter Story Id")  @PathVariable String storyId) {
		storyService.assignStoryToUser(userName, storyId);
		String msg= "story with Id " + storyId + " is assigned to User with Id " + userName;
		log.info("inside assign of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(msg), HttpStatus.OK);
	}

	@Operation(summary = "Delete Story", description = "Delete a story by story Id. Access by only Admin." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/storyId/{storyId}")
	public ResponseEntity<List<Story>> deleteStoryById(@Parameter(description = "Enter Story Id") @PathVariable String storyId){
		
		log.info("inside deleteStoryById of Story Controller");
		storyService.deleteStoryById(storyId);
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
	}
	
}
