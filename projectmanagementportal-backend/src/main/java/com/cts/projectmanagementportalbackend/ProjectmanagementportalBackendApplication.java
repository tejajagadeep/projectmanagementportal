package com.cts.projectmanagementportalbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Project Management Portal API", version = "1.6.11", description = "This is the UI for API of Project Management Portal"))
public class ProjectmanagementportalBackendApplication {

	static Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	public static void main(String[] args) {
		log.info("inside spring boot application");
		SpringApplication.run(ProjectmanagementportalBackendApplication.class, args);
	}
	

}
