package com.cts.projectmanagementportalbackend;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Project Management Portal Application", version = "1.0", description = "This is the Swagger UI for Project Management Portal Spring Boot Application."))
@SecurityScheme(
		name = "Bearer Authentication",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class ProjectmanagementportalBackendApplication {

	static Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	public static void main(String[] args) {
		log.info("inside spring boot application");
		SpringApplication.run(ProjectmanagementportalBackendApplication.class, args);
	}
	

}
