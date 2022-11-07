package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMBER')")
	@GetMapping("/getAllProjects")
	@PostFilter("filterObject.projectManagerName==authentication.name")
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getAllProjects1")
	public ResponseEntity<List<Project>> getAllProjects1(){
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@GetMapping("getProjectsByProjectManagerEmailId/{projectManagerEmailId}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerEmailId(@PathVariable String projectManagerEmailId){
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerEmailId(projectManagerEmailId),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@GetMapping("getProjectsByProjectName/{projectName}")
	public ResponseEntity<List<Project>> getProjectsByProjectName(@PathVariable String projectName){
		return new ResponseEntity<>(projectService.getProjectsByProjectName(projectName), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@GetMapping("getProjectsByProjectManagerName/{projectManagerName}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerName(@PathVariable String projectManagerName){
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerName(projectManagerName), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@GetMapping("getProjectsByStatus/{status}")
	public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status){
		return new ResponseEntity<>(projectService.getProjectsByStatus(status), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@GetMapping("/getProjectById/{projectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable String projectId) throws NoSuchElementExistException{
		return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/projectRegistration")
	@ResponseBody
	public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project) throws IdAlreadyExistException {
		return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEMEBER')")
	@PutMapping("/updateProjectById/{projectId}")
	@ResponseBody
	public ResponseEntity<Project> updateProjectById(@PathVariable String projectId, @Valid @RequestBody Project project) throws NoSuchElementExistException{
		return new ResponseEntity<>(projectService.updateProjectById(projectId, project), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/deleteProjectById/{projectId}")
	public ResponseEntity<List<Project>> deleteProjectById(@PathVariable String projectId) throws NoSuchElementExistException{
		projectService.deleteProjectById(projectId);
		return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
	}
	
	
}
