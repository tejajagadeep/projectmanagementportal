//package com.cts.projectmanagementportalbackend.service;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cts.projectmanagementportalbackend.model.Project;
//import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
//import com.cts.projectmanagementportalbackend.repository.StoryRepository;
//import com.cts.projectmanagementportalbackend.repository.UserRepository;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class ProjectServiceImplTest2 {
//	
//	@InjectMocks
//	ProjectServiceImpl projectServiceImpl;
//	
//	@Mock
//	ProjectRepository projectRepository;
//	
//	@Mock
//	StoryRepository storyRepository;
//	
//	@Mock
//	UserRepository userRepository;
//
//	@Test
//	void testGetAllProjects() {
//	}
//
//	@Test
//	void testGetProjectsByProjectManagerName() {
//	}
//
//	@Test
//	void testGetProjectsByStatus() {
//	}
//
//	@Test
//	void testGetProjectById() {
//	}
//
//	@Test
//	void testSaveProject() {
//		String dateString = "1999/07/28";
//		Date date = new Date(dateString);
//		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
//		
//		Project project = new Project("project1","project1",projectDescriptionDummy,"team1","5","manager1","manager1@gmail.com","tech1","tech1@gmail.com",date,date,"stack1","Completed","Completed");
////		project.setProjectId("projectId");
////		project.setProjectName("project1");
////		project.setProjectDescription(projectDescriptionDummy);
////		project.setProjectManagerName("manager1");
////		project.setProjectManagerEmailId("manager1@gmail.com");
////		project.setTechLeadName("tech1");
////		project.setTechLeadEmailId("tech1@gmail.com");
////		project.setTeamName("team1");
////		project.setTeamSize("5");
////		project.setProjectStartDate(date);
////		project.setProjectEndDate(date);
////		project.setStatus("Completed");
////		project.setRemarks("Completed");
//		System.out.println("project : "+project.getProjectId());
//		when(projectRepository.save(Mockito.mock(Project.class))).thenReturn(project);
//		Project projectDummy = projectServiceImpl.saveProject(project);
//		System.out.println(projectDummy.getProjectId());
//		Assertions.assertNotNull(projectDummy);
//		Assertions.assertEquals("project1", project.getProjectId());
//	}
//
//	@Test
//	void testUpdateProjectById() {
//	}
//
//	@Test
//	void testDeleteProjectById() {
//	}
//
//	@Test
//	void testAssign() {
//	}
//
//	@Test
//	void testAssignProjectToUser() {
//	}
//
//}
