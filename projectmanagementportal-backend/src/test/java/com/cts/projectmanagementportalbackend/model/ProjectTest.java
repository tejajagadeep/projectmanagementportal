package com.cts.projectmanagementportalbackend.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectTest {
	
	@InjectMocks
	Project project;
	
	private String dateString = "1999/07/28";
	private Date date = new Date(dateString);
	
	private String projectDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
	
	private Project projectObject = new Project("project1","project",projectDescriptionDummy,"team1","3","manager1","manager1@gmail.com","tech1","tech1@gamil.com", date, date, "stack1", "ongoing", "done");
	
	
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
		project.setTeamSize("3");
		assertEquals("3", project.getTeamSize());
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
		project.setStatus("ongoing");
		assertEquals("ongoing", project.getStatus());
	}

	@Test
	void testGetterSetterRemarks() {
		project.setRemarks("done");
		assertEquals("done", project.getRemarks());
	}
	
	@Test
	void testProject() {
		Project projectNoArgs = new Project();
		assertNotEquals(new Project(), projectNoArgs);
	}
//
//	@Test
//	void testProjectStringStringStringStringStringStringStringStringStringDateDateStringStringString() {
//		fail("Not yet implemented");
//	}


}
