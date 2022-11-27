package com.cts.projectmanagementportalbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectmanagementportalBackendApplication {

	static Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	public static void main(String[] args) {
		log.info("inside spring boot application");
		SpringApplication.run(ProjectmanagementportalBackendApplication.class, args);
	}
	

}
