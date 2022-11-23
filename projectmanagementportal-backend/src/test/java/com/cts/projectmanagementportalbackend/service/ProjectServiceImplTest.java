package com.cts.projectmanagementportalbackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.TeamSizeExcedsException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

//@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProjectServiceImplTest {

	@InjectMocks
	ProjectServiceImpl projectServiceImpl;

	@Mock
	ProjectRepository projectRepository;

	@Mock
	StoryRepository storyRepository;

	@Mock
	UserRepository userRepository;

	@MockBean
	ProjectRepository projectRepositoryBean;

	@Mock
	Project project;
	
	public List<Project> projects;

	@BeforeEach
	public void setProject() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		project.setProjectId("projectId");
		project.setProjectName("project1");
		project.setProjectDescription(projectDescriptionDummy);
		project.setProjectManagerName("manager1");
		project.setProjectManagerEmailId("manager1@gmail.com");
		project.setTechLeadName("tech1");
		project.setTechLeadEmailId("tech1@gmail.com");
		project.setTeamName("team1");
		project.setTeamSize("5");
		project.setProjectStartDate(date);
		project.setProjectEndDate(date);
		project.setTechStack("stack1");
		project.setStatus("Completed");
		project.setRemarks("Completed");

		String dateString1 = "1999/07/28";
		Date date1 = new Date(dateString1);
		String projectDescriptionDummy1 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		Project projectNew  = new Project();
		projectNew.setProjectId("project1");
		projectNew.setProjectName("project1");
		projectNew.setProjectDescription(projectDescriptionDummy1);
		projectNew.setProjectManagerName("manager1");
		projectNew.setProjectManagerEmailId("manager1@gmail.com");
		projectNew.setTechLeadName("tech1");
		projectNew.setTechLeadEmailId("tech1@gmail.com");
		projectNew.setTeamName("team1");
		projectNew.setTeamSize("5");
		projectNew.setProjectStartDate(date1);
		projectNew.setProjectEndDate(date1);
		projectNew.setTechStack("stack");
		projectNew.setStatus("Completed");
		projectNew.setRemarks("Completed");
			
		Project projectNew2  = new Project();
		projectNew2.setProjectId("project2");
		projectNew2.setProjectName("project2");
		projectNew2.setProjectDescription(projectDescriptionDummy1);
		projectNew2.setProjectManagerName("manager1");
		projectNew2.setProjectManagerEmailId("manager1@gmail.com");
		projectNew2.setTechLeadName("tech1");
		projectNew2.setTechLeadEmailId("tech1@gmail.com");
		projectNew2.setTeamName("team1");
		projectNew2.setTeamSize("5");
		projectNew2.setProjectStartDate(date1);
		projectNew2.setProjectEndDate(date1);
		projectNew2.setTechStack("stack");
		projectNew2.setStatus("Completed");
		projectNew2.setRemarks("Completed");
		
		List<Project> projectList = new ArrayList<>();
		
		projectList.add(projectNew);
		projectList.add(projectNew2);
		
		when(projectRepository.findAll()).thenReturn(projectList);
		when(projectRepository.findByStatus("Completed")).thenReturn(projectList);
		when(projectRepository.findByProjectManagerName("manager1")).thenReturn(projectList);
//		when(projectServiceImpl.saveProject(project)).thenReturn(project);
		
	}
	
	@Test
	void testGetAllProjectsMock() {
		
		
		
		assertEquals(2, projectServiceImpl.getAllProjects().size());
	}

	@Test
	void testGetAllProjects() {
		assertEquals(projectRepository.findAll(), projectServiceImpl.getAllProjects());
	}

	@Test
	void testGetProjectsByProjectManagerName() {
		String manager = "manager1";
		assertEquals(manager, projectServiceImpl.getProjectsByProjectManagerName(manager).get(1).getProjectManagerName());
		
	}

//	@Test
//	void testGetProjectsByStatus() {
//		String status = "To-Do";
//		List<Project> projectList = new ArrayList<>();
//		projectList.add(project);
//		when(projectServiceImpl.saveProject(project)).thenReturn(project);
//		when(projectServiceImpl.getProjectsByProjectManagerName(status)).thenReturn(projectList);
//		assertEquals(projectList, projectServiceImpl.getProjectsByProjectManagerName(status));
//	}

	@Test
	void testGetProjectsByStatus() {
		
		
		String status = "Completed";
		
		
		assertEquals(status, projectServiceImpl.getProjectsByStatus(status).get(1).getStatus());
		
	}
	
	@Test
	void testGetProjectsByStatusThrows() {
		
		
		String status = "hello";
		
		
		assertThrows(NoSuchElementExistException.class, ()-> projectServiceImpl.getProjectsByStatus(status).get(1).getStatus());
		
	}

	@Test
	void testGetProjectByIdNull() {
		String dateString1 = "1999/07/28";
		Date date1 = new Date(dateString1);
		String projectDescriptionDummy1 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		Project projectNew  = new Project();
		projectNew.setProjectId("project1");
		projectNew.setProjectName("project1");
		projectNew.setProjectDescription(projectDescriptionDummy1);
		projectNew.setProjectManagerName("manager1");
		projectNew.setProjectManagerEmailId("manager1@gmail.com");
		projectNew.setTechLeadName("tech1");
		projectNew.setTechLeadEmailId("tech1@gmail.com");
		projectNew.setTeamName("team1");
		projectNew.setTeamSize("5");
		projectNew.setTechStack("stack");
		projectNew.setProjectStartDate(date1);
		projectNew.setProjectEndDate(date1);
		projectNew.setStatus("Completed");
		projectNew.setRemarks("Completed");
		String projectId = "projec";
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.getProjectById(projectId));

	}
	
	@Test
	void testGetProjectById() {
		
		String projectId = "projectId";
		when(projectRepository.findByProjectId(projectId)).thenReturn(project);
		assertEquals(projectRepository.findByProjectId(projectId), projectServiceImpl.getProjectById(projectId));

	}

	@Test
	void testSaveProject() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		Project projectNew12  = new Project();
		projectNew12.setProjectId("project12");
		projectNew12.setProjectName("project12");
		projectNew12.setProjectDescription(projectDescriptionDummy11);
		projectNew12.setProjectManagerName("jagadeep");
		projectNew12.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew12.setTechLeadName("jagadeep");
		projectNew12.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew12.setTeamName("team11");
		projectNew12.setTeamSize("5");
		projectNew12.setProjectStartDate(date11);
		projectNew12.setProjectEndDate(date11);
		projectNew12.setTechStack("stack11");
		projectNew12.setStatus("Completed");
		projectNew12.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(null);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertEquals(projectNew11,projectServiceImpl.saveProject(projectNew11));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("projt11", projectNew11));
	}
	
	@Test
	void testSaveProjectnotNull() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		
		
		Project projectNew12  = new Project();
		projectNew12.setProjectId("project12");
		projectNew12.setProjectName("project12");
		projectNew12.setProjectDescription(projectDescriptionDummy11);
		projectNew12.setProjectManagerName("jagadeep");
		projectNew12.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew12.setTechLeadName("jagadeep");
		projectNew12.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew12.setTeamName("team11");
		projectNew12.setTeamSize("5");
		projectNew12.setProjectStartDate(date11);
		projectNew12.setProjectEndDate(date11);
		projectNew12.setTechStack("stack11");
		projectNew12.setStatus("Completed");
		projectNew12.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(IdAlreadyExistException.class,()->projectServiceImpl.saveProject(projectNew11));
		assertEquals(projectNew11,projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testUpdateProjectnotNull() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagaep");
		projectNew11.setProjectManagerEmailId("jagadep@gmail.com");
		projectNew11.setTechLeadName("jagaep");
		projectNew11.setTechLeadEmailId("jagaeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadep@gmail.com")).thenReturn(null);
		when(userRepository.findByEmailAddress("jagaeep@gmail.com")).thenReturn(null);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testUpdateProjectnotNullTchNull() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadep@gmail.com");
		projectNew11.setTechLeadName("jagaep");
		projectNew11.setTechLeadEmailId("jagaeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadep@gmail.com")).thenReturn(userNew);
//		when(userRepository.findByEmailAddress("jagaep")).thenReturn(null);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testUpdateProjectnotNullProjectMismatch() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagaep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(InvalidUserException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testUpdateProjectnotNullTechMismatch() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
//		when(userRepository.findByEmailAddress("jagaep")).thenReturn(null);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(InvalidUserException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testSaveProjectT() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		
		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("manager11@gmail.com");
		projectNew11.setTechLeadName("tech11");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		when(userRepository.findByEmailAddress("manager11@gmail.com")).thenReturn(userNew);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.saveProject(projectNew11));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("projt11", projectNew11));

	}
	
	@Test
	void testSaveNullException() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("manager11");
		projectNew11.setProjectManagerEmailId("manager11@gmail.com");
		projectNew11.setTechLeadName("tech11");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		when(userRepository.findByEmailAddress("manager11@gmail.com")).thenReturn(null);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.saveProject(projectNew11));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testSaveManagerMismatchException() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("maanager");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("tech1");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(null);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		assertThrows(InvalidUserException.class,()->projectServiceImpl.saveProject(projectNew11));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testSaveTechLeadMismatchException() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("tech1");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com\"")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(null);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		
		assertThrows(InvalidUserException.class,()->projectServiceImpl.saveProject(projectNew11));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}

	@Test
	void testUpdateTechLeadMismatchException() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("tech1");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(projectRepository.save(projectNew11)).thenReturn(projectNew11);
		
		assertThrows(InvalidUserException.class,()->projectServiceImpl.updateProjectById("project11", projectNew11));
	}
	
	@Test
	void testUpdateProjectById() {
//		fail("Not yet implemented");
	}

	@Test
	void testDeleteProjectById() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		
		projectServiceImpl.deleteProjectById("project11");
//		when(projectRepository.deleteById("project11")).thenReturn(projectNew11);
		verify(projectRepository,times(1)).deleteById("project11");
//		assertThat(projectRepository.findById("project11")).isNull();
	}
	
	@Test
	void testDeleteProjectByIdException() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(projectRepository.findByProjectId("projec11")).thenReturn(null);
//		projectServiceImpl.deleteProjectById("projec11");
//		when(projectRepository.deleteById("project11")).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.deleteProjectById("proje11"));

	}

	@Test
	void testAssign() {
		
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		Set<Project> projectSet = new HashSet<>();
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		
		
		projectSet = userNew.getProjects();
//		projectSet.add(projectNew11);
//		userNew.setProjects(projectSet);
//		userRepository.save(userNew);
//		verify(userRepository,times(1)).save(userNew);
	}
	
	@Test
	void testAssignExceptionNUllproject() {
		when(userRepository.findByUserName("jagadep")).thenReturn(null);
		when(projectRepository.findByProjectId("projet11")).thenReturn(null);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.assign("jagadep", "projet11"));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.assignProjectToUser("jagadep", "projet11"));
	}

	@Test
	void testAssignExceptionUser() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		
		when(userRepository.findByUserName("jagadep")).thenReturn(null);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.assign("jagadep", "project11"));
		assertThrows(NoSuchElementExistException.class,()->projectServiceImpl.assignProjectToUser("jagadep", "project11"));

	}
	
	@Test
	void testAssignProjectToUserException() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		ArrayList<String> toUsers = new ArrayList();
		toUsers.add("jagadeep");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		projectNew11.setProjectAssignedToUsers(toUsers);
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		
		assertThrows(IdAlreadyExistException.class,()->projectServiceImpl.assignProjectToUser("jagadeep", "project11"));

	}
	
	@Test
	void testAssignProjectToUserException3() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		ArrayList<String> toUsers = new ArrayList();
		toUsers.add("jagadeep4");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep1");
		projectNew11.setProjectManagerEmailId("jagadeep1@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("1");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		projectNew11.setProjectOwner("jagadeep");
		projectNew11.setProjectAssignedToUsers(toUsers);
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		
//		assertThrows(TeamSizeExcedsException.class,()->projectServiceImpl.assignProjectToUser("jagadeep", "project11"));

	}
	
	@Test
	void testAssignProjectToUserException4() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		ArrayList<String> toUsers = new ArrayList();
		toUsers.add("jagadeep");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep");
		projectNew11.setProjectManagerEmailId("jagadeep@gmail.com");
		projectNew11.setTechLeadName("jagadeep");
		projectNew11.setTechLeadEmailId("jagadeep@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		projectNew11.setProjectAssignedToUsers(toUsers);
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		
		assertThrows(IdAlreadyExistException.class,()->projectServiceImpl.assignProjectToUser("jagadeep", "project11"));

	}
	
	@Test
	void testAssignProjectToUser() {
		String dateString11 = "1999/07/28";
		Date date11 = new Date(dateString11);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		
		ArrayList<String> toUsers = new ArrayList();
		toUsers.add("jagadeep4");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date11);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jagadeep1");
		projectNew11.setProjectManagerEmailId("jagadeep1@gmail.com");
		projectNew11.setTechLeadName("jagadeep2");
		projectNew11.setTechLeadEmailId("jagadeep2@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date11);
		projectNew11.setProjectEndDate(date11);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		projectNew11.setProjectOwner("jagadeep3");
		projectNew11.setProjectAssignedToUsers(toUsers);
		
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
//		projectServiceImpl.assignProjectToUser("jagadeep","project11");
//		verify(userRepository,times(1)).save(userNew);
	}

}
