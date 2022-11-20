package com.cts.projectmanagementportalbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, String>{

	public Story findByStoryId(String storyId);
	
	public List<Story> findByProjectIdName(String projectIdName);
	
}
