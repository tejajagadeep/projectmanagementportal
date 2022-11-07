package com.cts.projectmanagementportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.Story;

@Repository
public interface StoryReposiotry extends JpaRepository<Story, String>{

}
