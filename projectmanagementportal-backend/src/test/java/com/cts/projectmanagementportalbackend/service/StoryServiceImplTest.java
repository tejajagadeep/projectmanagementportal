package com.cts.projectmanagementportalbackend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Project;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.ProjectRepository;
import com.cts.projectmanagementportalbackend.repository.StoryRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@SpringBootTest
class StoryServiceImplTest {
	
	@InjectMocks
	StoryServiceImpl storyServiceImpl;
	
	@Mock
	StoryRepository storyRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	ProjectRepository projectRepository;
	
	@BeforeEach
	public void setupString() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("assignee");
		story1.setAssigneeEmailId("assignee@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		
		Story story2=new Story();
		story2.setStoryId("storyb");
		story2.setStoryTitle("storyb");
		story2.setStoryDescription(storyDescriptionDummy);
		story2.setAssignee("assignee");
		story2.setAssigneeEmailId("assignee@gmail.com");
		story2.setAssignmentDate(date);
		story2.setTargetDate(date);
		story2.setStatus("Completed");
		story2.setRemarks("Completed");
		story2.setProjectIdName("project");
		
		List<Story> stories = new ArrayList<>();
		stories.add(story1);
		stories.add(story2);
		when(storyRepository.findAll()).thenReturn(stories);
	}

	@Test
	void testGetAllStories() {
		assertEquals(2, storyServiceImpl.getAllStories().size());
	}
	
	@Test
	void testGetStoryById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("assignee");
		story1.setAssigneeEmailId("assignee@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		
		assertEquals(story1,storyServiceImpl.getStoryById("story"));
	}
	
	@Test
	void testGetStoryByIdExceptionnoyNull() {
		when(storyRepository.findByStoryId("stodry")).thenReturn(null);
		
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.getStoryById("stodry"));
	}

	@Test
	void testSaveStoryException() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("assignee");
		story1.setAssigneeEmailId("assignee@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		when(storyRepository.findByStoryId("story")).thenReturn(null);
		
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.saveStory(story1));
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.updateStoryAdmin("story", story1));

	}

	@Test
	void testSaveStoryExceptionNotNull() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("assignee");
		story1.setAssigneeEmailId("assignee@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		
		assertThrows(IdAlreadyExistException.class,()->storyServiceImpl.saveStory(story1));
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.updateStoryAdmin("story", story1));
	}
	
	@Test
	void testSaveStory() {
		
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagadeep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(storyRepository.findByStoryId("story")).thenReturn(null);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(storyRepository.save(story1)).thenReturn(story1);
		assertEquals(story1,storyServiceImpl.saveStory(story1));
	}
	
	@Test
	void testSaveStoryMisMatch() {
		
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagadep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(storyRepository.findByStoryId("story")).thenReturn(null);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(storyRepository.save(story1)).thenReturn(story1);
		assertThrows(InvalidUserException.class,()->storyServiceImpl.saveStory(story1));
	}
	
	
	@Test
	void testUpdateStoryAdmin() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagadeep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(storyRepository.save(story1)).thenReturn(story1);
		assertEquals(story1,storyServiceImpl.updateStoryAdmin("story", story1));
	}
	
	@Test
	void testUpdateStoryAdminMismatch() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagad1eep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		when(userRepository.findByEmailAddress("jagadeep@gmail.com")).thenReturn(userNew);
		when(storyRepository.save(story1)).thenReturn(story1);
		assertThrows(InvalidUserException.class,()->storyServiceImpl.updateStoryAdmin("story", story1));

	}

	@Test
	void testDeleteStoryById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagad1eep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		
		storyRepository.deleteById("story");
		storyServiceImpl.deleteStoryById("story");
		verify(storyRepository, times(1)).delete(story1);
	}
	
	@Test
	void testDeleteStoryByIdNullException() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(storyDescriptionDummy);
		story1.setAssignee("jagad1eep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		when(storyRepository.findByStoryId("story")).thenReturn(null);
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.deleteStoryById("story"));

	}

	@Test
	void testAssignExceptionprojectnull() {
		when(projectRepository.findByProjectId("project11")).thenReturn(null);
		
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.assign("project", "story"));

	}
	
	@Test
	void testAssignExceptionstorynull() {
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
		when(storyRepository.findByStoryId("story")).thenReturn(null);
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.assign("project11", "story"));
		
	}
	
	@Test
	void testAssignExceptionUserNull() {
		when(userRepository.findByUserName("jagadee")).thenReturn(null);
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.assignStoryToUser("jagadee", "story"));
		
	}
	
	@Test
	void testAssignExceptionStoryNull() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(storyRepository.findByStoryId("story")).thenReturn(null);
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.assignStoryToUser("jagadeep", "story"));
		
	}

	@Test
	void testAssignStoryToUserExceptionAlreadyExist() {
		
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		ArrayList<String> toUser = new ArrayList<>();
		toUser.add("jagadeep");
		
		User userNew = new User();
		userNew.setUserName("jagadeep");
		userNew.setName("jagadeep");
		userNew.setEmailAddress("jagadeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(projectDescriptionDummy11);
		story1.setAssignee("jagad1eep");
		story1.setAssigneeEmailId("jagadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
		story1.setStoryAssignedToUsers(toUser);

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
		projectNew11.setProjectStartDate(date);
		projectNew11.setProjectEndDate(date);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
	
		when(userRepository.findByUserName("jagadeep")).thenReturn(userNew);
		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		assertThrows(IdAlreadyExistException.class,()->storyServiceImpl.assignStoryToUser("jagadeep", "story"));
		assertThrows(IdAlreadyExistException.class,()->storyServiceImpl.assignStoryToUser("jagadeep", "story"));
	}

	@Test
	void testAssignStoryToUserExceptionnotExist() {
		
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String projectDescriptionDummy11 = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
		ArrayList<String> toUser = new ArrayList<>();
		toUser.add("jagadeep");
		
		User userNew = new User();
		userNew.setUserName("jgeep");
		userNew.setName("jgadeep");
		userNew.setEmailAddress("jgaeep@gmail.com");
		userNew.setContactNo(7894561230L);
		userNew.setDateOfBirth(date);
		userNew.setRole("Admin");
		userNew.setPassword("{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");

		Story story1=new Story();
		story1.setStoryId("story");
		story1.setStoryTitle("story");
		story1.setStoryDescription(projectDescriptionDummy11);
		story1.setAssignee("jagad1eep");
		story1.setAssigneeEmailId("jadeep@gmail.com");
		story1.setAssignmentDate(date);
		story1.setTargetDate(date);
		story1.setStatus("Completed");
		story1.setRemarks("Completed");
		story1.setProjectIdName("project");
//		story1.setStoryAssignedToUsers(toUser);

		Project projectNew11  = new Project();
		projectNew11.setProjectId("project11");
		projectNew11.setProjectName("project11");
		projectNew11.setProjectDescription(projectDescriptionDummy11);
		projectNew11.setProjectManagerName("jaeep");
		projectNew11.setProjectManagerEmailId("jaga1deep@gmail.com");
		projectNew11.setTechLeadName("jeep");
		projectNew11.setTechLeadEmailId("tech11@gmail.com");
		projectNew11.setTeamName("team11");
		projectNew11.setTeamSize("5");
		projectNew11.setProjectStartDate(date);
		projectNew11.setProjectEndDate(date);
		projectNew11.setTechStack("stack11");
		projectNew11.setStatus("Completed");
		projectNew11.setRemarks("Completed");
		projectNew11.setProjectOwner("jagadee");
		projectNew11.setProjectAssignedToUsers(toUser);
	
		when(userRepository.findByUserName("jgeep")).thenReturn(userNew);
		when(storyRepository.findByStoryId("story")).thenReturn(story1);
		when(projectRepository.findByProjectId("project11")).thenReturn(projectNew11);
		assertThrows(NoSuchElementExistException.class,()->storyServiceImpl.assignStoryToUser("jgeep", "story"));
	}
}
