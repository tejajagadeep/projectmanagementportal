package com.cts.projectmanagementportalbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.repository.ProjectRepository;

@RestController
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;
	
//	@GetMapping(/getAllProjects)
//	public 
	
}
