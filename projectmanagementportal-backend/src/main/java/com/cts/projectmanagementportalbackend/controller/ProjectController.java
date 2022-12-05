package com.cts.projectmanagementportalbackend.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.service.ProjectService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);

	@Operation(summary = "Retrieve Projects", description = "Retrieve All the Projects from the data base." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("")
//	@PostFilter("filterObject.projectManagerName==authentication.name")
	public ResponseEntity<List<Project>> getAllProjects(){
		log.info("inside getAllProjects of project Controller");
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}

	@Operation(summary = "Retrieve Projects by Project Manager.", description = "Retrieve all Projects details from the data base by project manager name." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/projectManagerName/{projectManagerName}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerName(@Parameter(description = "Enter Project Manager Name") @PathVariable String projectManagerName){

		log.info("inside getProjectsByProjectManagerName of project Controller");
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerName(projectManagerName), HttpStatus.OK);
	}


	@Operation(summary = "Retrieve Projects by Status", description = "Retrieve All the Projects from the data base by status of the project." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Project>> getProjectsByStatus(@Parameter(description = "Enter Project Status.( 'To-Do', 'In-Progress', 'Ready-For-Test', 'Completed') ") @PathVariable String status){

		log.info("inside getProjectsByStatus of project Controller");
		return new ResponseEntity<>(projectService.getProjectsByStatus(status), HttpStatus.OK);
	}

	@Operation(summary = "Retrieve Project", description = "Retrieve a Project details from the data base by project id." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/projectId/{projectId}")
	public ResponseEntity<Project> getProjectById(@Parameter(description = "Enter Project Id") @PathVariable String projectId){

		log.info("inside getProjectById of project Controller");
		return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
	}

	@Operation(summary = "Save Project", description = "Save project details into the data base. Access by only admin." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Project> saveProject(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Enter Project Details") @Valid @RequestBody Project project)  {

		log.info("inside saveProject of project Controller");
		return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
	}

	@Operation(summary = "Update Project", description = "Update project details by project Id and save it into the data base. Access by only admin" ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/projectId/{projectId}")
	@ResponseBody
	public ResponseEntity<Project> updateProjectById(@Parameter(description = "Enter Project Id") @PathVariable String projectId,@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Enter Project Details")  @Valid @RequestBody Project project){

		log.info("inside updateProjectById of project Controller");
		return new ResponseEntity<>(projectService.updateProjectById(projectId, project), HttpStatus.OK);
	}

	@Operation(summary = "Assign Project", description = "Assign a project to user. Access by only admin" ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/projectAssign/{userName}/project/{projectId}")
	public ResponseEntity<MessageResponse> assign(@Parameter(description = "Enter User Id") @PathVariable String userName,@Parameter(description = "Enter Project Id")  @PathVariable String projectId) {
		projectService.assign(userName, projectId);
		String msg= "user with name " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assign of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(new Date(),msg,HttpStatus.OK), HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@Operation(summary = "Assign Project to User", description = "Assign project to user by fetching project Id and user Id. Access by admin." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/assignProjectToUser/{userName}/project/{projectId}")
	public ResponseEntity<MessageResponse> assignProjectToUser(@Parameter(description = "Enter User Id") @PathVariable String userName,@Parameter(description = "Enter Project Id")  @PathVariable String projectId) {
		projectService.assignProjectToUser(userName, projectId);
		String msg= "User with Id " + userName + " is assigned to project with Id " + projectId;
		log.info("inside assignProjectToUser of Story Controller "+msg);
		return new ResponseEntity<>(new MessageResponse(new Date(),msg,HttpStatus.OK), HttpStatus.OK);
	}
	
	/*
	 * 
	 */
	@Operation(summary = "Delete Project", description = "Delete a project by project Id. Access by only admin." ) //method level
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/projectId/{projectId}")
	public ResponseEntity<List<Project>> deleteProjectById(@Parameter(description = "Enter Project Id") @PathVariable String projectId){

		log.info("inside deleteProjectById of project Controller");
		projectService.deleteProjectById(projectId);
		return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
	}
	
	
}
