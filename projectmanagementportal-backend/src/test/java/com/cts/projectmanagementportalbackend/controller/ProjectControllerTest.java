package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.service.ProjectService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class ProjectControllerTest {

	@InjectMocks
	ProjectController projectController;
	
	@Mock
	ProjectService projectService;
	
	List<Project> projectList;
	Project project;
	MessageResponse messageResponse;
	
	@Test
	@Order(1)
	void testGetAllProjects() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		projectList = new ArrayList<>();
		projectList.add(new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed"));
		projectList.add(new Project("project2","project2",projectDescriptionDummy,"team2","5","manager2","manager2@gmail.com","tech2","tech2@gamil.com", date, date, "stack2", "Completed", "Completed"));
		
		when(projectService.getAllProjects()).thenReturn(projectList);
		ResponseEntity<List<Project>> response = projectController.getAllProjects();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}

	@Test
	@Order(2)
	void testGetProjectsByProjectManagerName() {
		
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		projectList = new ArrayList<>();
		projectList.add(new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed"));
		projectList.add(new Project("project2","project2",projectDescriptionDummy,"team2","5","manager2","manager2@gmail.com","tech2","tech2@gamil.com", date, date, "stack2", "Completed", "Completed"));
		
		when(projectService.getProjectsByProjectManagerName("user1")).thenReturn(projectList);
		ResponseEntity<List<Project>> response = projectController.getProjectsByProjectManagerName("user1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(3)
	void testGetProjectsByStatus() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		projectList = new ArrayList<>();
		projectList.add(new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed"));
		projectList.add(new Project("project2","project2",projectDescriptionDummy,"team2","5","manager2","manager2@gmail.com","tech2","tech2@gamil.com", date, date, "stack2", "Completed", "Completed"));
	
		project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed");
		when(projectService.getProjectsByStatus("Completed")).thenReturn(projectList);
		ResponseEntity<List<Project>> response = projectController.getProjectsByStatus("Completed");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(4)
	void testGetProjectById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed");
		
		when(projectService.getProjectById("project1")).thenReturn(project);
		ResponseEntity<Project> response = projectController.getProjectById("project1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(5)
	void testSaveProject() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed");
		
		when(projectService.saveProject(project)).thenReturn(project);
		ResponseEntity<Project> response = projectController.saveProject(project);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	@Order(6)
	void testUpdateProjectById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed");
		
		when(projectService.updateProjectById("project1", project)).thenReturn(project);
		ResponseEntity<Project> response = projectController.updateProjectById("project1", project);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(7)
	void testAssign() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "Completed", "Completed");
		
		messageResponse = new MessageResponse(new Date(), "abc",HttpStatus.OK);
		ResponseEntity<MessageResponse> response = projectController.assign("user1", "project1");
		projectService.assign("user1", "project1");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(8)
	void testAssignProjectToUser() {
		messageResponse = new MessageResponse(new Date(), "abc",HttpStatus.OK);
		ResponseEntity<MessageResponse> response = projectController.assignProjectToUser("user1", "project1");
		projectService.assignProjectToUser("user1", "project1");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(9)
	void testDeleteProjectById() {
		messageResponse = new MessageResponse(new Date(), "abc",HttpStatus.OK);
		ResponseEntity<List<Project>> response = projectController.deleteProjectById("project1");
		projectService.deleteProjectById("project1");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
