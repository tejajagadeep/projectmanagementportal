package com.cts.projectmanagementportalbackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

	public Project findByProjectId(String projectId);
	
	public List<Project> findByProjectOwner(String projectOwner);
	
	public List<Project> findByProjectManagerName(String projectManagerName);
	
	public List<Project> findByTechLeadName(String teachLeadName);
	
	public List<Project> findByStatus(String status);
	
//	public Project findByProjectAssignedToUsers(String[] projectAssignedToUsers);
}
