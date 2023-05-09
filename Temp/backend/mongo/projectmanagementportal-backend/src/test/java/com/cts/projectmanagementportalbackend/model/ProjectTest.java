package com.cts.projectmanagementportalbackend.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

@SpringBootTest
class ProjectTest {

	@InjectMocks
	Project project;
	
	@InjectMocks
	Story story;
	
//	private ArrayList<String> projectAssignedToUsers;
//	private ArrayList<String> projectAssignedToUsersDummy = new ArrayList<>(projectAssignedToUsers);
	
	
	
	
	private String dateString = "1999/07/28";
	private Date date = new Date(dateString);
	
	private String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
	
	private Project projectObject = new Project("project2","project2",projectDescriptionDummy,"team2","5","manager2","manager2@gmail.com","tech2","tech2@gamil.com", date, date, "stack2", "Completed", "Completed");
	


	
	@Test
	void testGetterSetterProjectId() {
		project.setProjectId("project1");
		assertEquals("project1", project.getProjectId());
	}

	@Test
	void testGetterSetterProjectName() {
		project.setProjectName("project1");
		assertEquals("project1", project.getProjectName());
	}

	@Test
	void testGetterSetterProjectDescription() {
			project.setProjectDescription(projectDescriptionDummy);
		assertEquals(projectDescriptionDummy, project.getProjectDescription());
	}

	@Test
	void testGetterSetterTeamName() {
		project.setTeamName("team1");
		assertEquals("team1", project.getTeamName());
	}

	@Test
	void testGetterSetterTeamSize() {
		project.setTeamSize("5");
		assertEquals("5", project.getTeamSize());
	}

	@Test
	void testGetterSetterProjectManagerName() {
		project.setProjectManagerName("manager1");
		assertEquals("manager1", project.getProjectManagerName());
	}

	@Test
	void testGetterSetterProjectManagerEmailId() {
		project.setProjectManagerEmailId("manager1@gmail.com");
		assertEquals("manager1@gmail.com", project.getProjectManagerEmailId());
	}

	@Test
	void testGetterSetterTechLeadName() {
		project.setTechLeadName("tech1");
		assertEquals("tech1", project.getTechLeadName());
	}

	@Test
	void testGetterSetterTechLeadEmailId() {
		project.setTechLeadEmailId("tech1@gamil.com");
		assertEquals("tech1@gamil.com", project.getTechLeadEmailId());
	}

	@Test
	void testGetterSetterProjectStartDate() {
		project.setProjectStartDate(date);
		assertEquals(date, project.getProjectStartDate());
	}

	@Test
	void testGetterSetterProjectEndDate() {
		project.setProjectEndDate(date);
		assertEquals(date, project.getProjectEndDate());
	}

	@Test
	void testGetterSetterTechStack() {
		project.setTechStack("stack1");
		assertEquals("stack1", project.getTechStack());
	}

	@Test
	void testGetterSetterStatus() {
		project.setStatus("Completed");
		assertEquals("Completed", project.getStatus());
	}

	@Test
	void testGetterSetterRemarks() {
		project.setRemarks("Completed");
		assertEquals("Completed", project.getRemarks());
	}
	

	@Test
	void testGetterSetterProjectOwner() {
		project.setProjectOwner("jagadeep");
		assertEquals("jagadeep", project.getProjectOwner());
	}

	@Test
	void testAddProjectAssignedToUsers() {
		ArrayList<String> assginUser = new ArrayList<>();
	assginUser.add("user1");
	project.setProjectAssignedToUsers(assginUser);
	assertEquals(assginUser,project.getProjectAssignedToUsers());
	}
	
	@Test
	void testProject() {
		Project projectNoArgs = new Project();
		assertNotEquals(new Project(), projectNoArgs);
	}
	
	

	@Test
	void testAddStory() {
		String toString = project.toString();
		assertEquals(project.toString(),toString);
	}

	@Test
	void testaddProjectAssignedToUsers() {
		ArrayList<String> assginUser2 = new ArrayList<>();
		assginUser2.add("user2");
		project.addProjectAssignedToUsers("user2");
		assertEquals(assginUser2,project.getProjectAssignedToUsers());
	}

	@Test
	void testGetterSetterStories() {
		Set<Story> assginStory = new HashSet<>();
		assginStory.add(story);
		project.setStories(assginStory);
		assertEquals(assginStory,project.getStories());
		
	}
	
	@Test
	void testaddStories() {
		Set<Story> assginStory = new HashSet<>();
		assginStory.add(story);
		project.addStory(story);
		assertEquals(assginStory,project.getStories());
		
	}

	@Test
	void testToProject() {
//		fail("Not yet implemented");
	}
}
