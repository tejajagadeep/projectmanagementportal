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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getAllProjects")
//	@PostFilter("filterObject.projectManagerName==authentication.name")
	public ResponseEntity<List<Project>> getAllProjects(){
		log.info("inside getAllProjects of project Controller");
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getProjectsByProjectManagerName/{projectManagerName}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerName(@PathVariable String projectManagerName){

		log.info("inside getProjectsByProjectManagerName of project Controller");
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerName(projectManagerName), HttpStatus.OK);
	}
	
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getProjectsByStatus/{status}")
	public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status){

		log.info("inside getProjectsByStatus of project Controller");
		return new ResponseEntity<>(projectService.getProjectsByStatus(status), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getProjectById/{projectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable String projectId){

		log.info("inside getProjectById of project Controller");
		return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/projectRegistration")
	@ResponseBody
	public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project)  {

		log.info("inside saveProject of project Controller");
		return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/updateProjectById/{projectId}")
	@ResponseBody
	public ResponseEntity<Project> updateProjectById(@PathVariable String projectId, @Valid @RequestBody Project project){

		log.info("inside updateProjectById of project Controller");
		return new ResponseEntity<>(projectService.updateProjectById(projectId, project), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("updateProjectAssign/{userName}/project/{projectId}")
	public ResponseEntity<MessageResponse> assign(@PathVariable String userName, @PathVariable String projectId) {
		projectService.assign(userName, projectId);
		String msg= "user with name " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(msg), HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("assignProjectToUser/{userName}/project/{projectId}")
	public ResponseEntity<MessageResponse> assignProjectToUser(@PathVariable String userName, @PathVariable String projectId) {
		projectService.assignProjectToUser(userName, projectId);
		String msg= "User with Id " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assignProjectToUser of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(msg), HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/deleteProjectById/{projectId}")
	public ResponseEntity<List<Project>> deleteProjectById(@PathVariable String projectId){

		log.info("inside deleteProjectById of project Controller");
		projectService.deleteProjectById(projectId);
		return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
	}
	
	
}
