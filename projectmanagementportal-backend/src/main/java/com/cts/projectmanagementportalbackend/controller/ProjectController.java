package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping("/getAllProjects")
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@GetMapping("getProjectsByProjectManagerEmailId/{projectManagerEmailId}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerEmailId(@PathVariable String projectManagerEmailId){
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerEmailId(projectManagerEmailId),HttpStatus.OK);
	}
	
	@GetMapping("getProjectsByProjectName/{projectName}")
	public ResponseEntity<List<Project>> getProjectsByProjectName(@PathVariable String projectName){
		return new ResponseEntity<>(projectService.getProjectsByProjectName(projectName), HttpStatus.OK);
	}
	
	@GetMapping("getProjectsByProjectManagerName/{projectManagerName}")
	public ResponseEntity<List<Project>> getProjectsByProjectManagerName(@PathVariable String projectManagerName){
		return new ResponseEntity<>(projectService.getProjectsByProjectManagerName(projectManagerName), HttpStatus.OK);
	}
	
	@GetMapping("getProjectsByStatus/{status}")
	public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status){
		return new ResponseEntity<>(projectService.getProjectsByStatus(status), HttpStatus.OK);
	}
	
	@PostMapping("/projectRegiration")
	@ResponseBody
	public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project) throws ElementAlreadyExistException {
		return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProjectById/{projectId}")
	@ResponseBody
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project, @PathVariable String projectId) throws NoSuchElementExistException{
		return new ResponseEntity<>(projectService.updateProject(project, projectId), HttpStatus.OK);
	}
	
	
}
