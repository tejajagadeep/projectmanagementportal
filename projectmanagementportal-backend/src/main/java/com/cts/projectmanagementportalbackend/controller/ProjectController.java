package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@GetMapping("getProjectsByProjectManagerEmailId/{projectManagerEmailId}")
	public List<Project> getProjectsByProjectManagerEmailId(@PathVariable String projectManagerEmailId){
		return projectService.getProjectsByProjectManagerEmailId(projectManagerEmailId);
	}
	
	@GetMapping("getProjectsByProjectName/{projectName}")
	public List<Project> getProjectsByProjectName(@PathVariable String projectName){
		return projectService.getProjectsByProjectName(projectName);
	}
	
	@GetMapping("getProjectsByProjectManagerName/{projectManagerName}")
	public List<Project> getProjectsByProjectManagerName(@PathVariable String projectManagerName){
		return projectService.getProjectsByProjectManagerName(projectManagerName);
	}
	
	@GetMapping("getProjectsByStatus/{status}")
	public List<Project> getProjectsByStatus(@PathVariable String status){
		return projectService.getProjectsByStatus(status);
	}
	
	@PostMapping("/projectRegiration")
	public Project postProject(@Valid @RequestBody Project project) {
		return projectService.postProject(project);
	}
	
}
