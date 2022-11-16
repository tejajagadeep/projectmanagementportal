package com.cts.projectmanagementportalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.Story;

@Repository
public interface StoryReposiotry extends JpaRepository<Story, String>{

	public List<Story> findByProjectIdName(String projectIdName);
	
}
