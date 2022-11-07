package com.cts.projectmanagementportalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{

	public List<Project> findByProjectManagerEmailId(String projectManagerEmailId);
	
	public List<Project> findByProjectName(String projectName);
	
	public List<Project> findByProjectManagerName(String projectManagerName);
	
	public List<Project> findByStatus(String status);
	
}
