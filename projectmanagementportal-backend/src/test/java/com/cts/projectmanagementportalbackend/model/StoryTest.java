package com.cts.projectmanagementportalbackend.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoryTest {

	@InjectMocks
	Story story;
	
	private String dateString = "1999/07/28";
	private Date date = new Date(dateString);
	
	private String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";
	
//	private Story storyObject = new Story("story1","Project1","storyTitle",storyDescriptionDummy,"Assignee","Assignee@gmail.com",date, date,"ongoing","done");

	@Test
	void testGetterSetterStoryId() {
		story.setStoryId("story1");
		assertEquals("story1", story.getStoryId());
	}

//	@Test
//	void testGetterSetterProjectId() {
//		story.setProjectId("Project1");
//		assertEquals("Project1", story.getProjectId());
//	}

	@Test
	void testGetterSetterStoryTitle() {
		story.setStoryTitle("story1");
		assertEquals("story1", story.getStoryTitle());
	}

	@Test
	void testGetterSetterStoryDescription() {
		story.setStoryDescription(storyDescriptionDummy);
		assertEquals(storyDescriptionDummy, story.getStoryDescription());
	}

	@Test
	void testGetterSetterAssignee() {
		story.setAssignee("Assignee1");
		assertEquals("Assignee1", story.getAssignee());
	}

	@Test
	void testGetterSetterAssigneeEmailId() {
		story.setAssigneeEmailId("Assignee1@gmail.com");
		assertEquals("Assignee1@gmail.com", story.getAssigneeEmailId());
	}

	@Test
	void testGetterSetterAssignmentDate() {
		story.setAssignmentDate(date);
		assertEquals(date, story.getAssignmentDate());
	}

	@Test
	void testGetterSetterTargetDate() {
		story.setTargetDate(date);
		assertEquals(date, story.getTargetDate());
	}

	@Test
	void testGetterSetterStatus() {
		story.setStatus("Completed");
		assertEquals("Completed", story.getStatus());
	}

	@Test
	void testGetterSetterRemarks() {
		story.setRemarks("Completed");
		assertEquals("Completed", story.getRemarks());
	}
	@Test
	void testAddStoryAssignedToUsers() {
		ArrayList<String> assginUser = new ArrayList<>();
		assginUser.add("user1");
		story.setStoryAssignedToUsers(assginUser);
		assertEquals(assginUser,story.getStoryAssignedToUsers());
		
		
	}

	@Test
	void testGetProjectIdName() {
		story.setProjectIdName("project1");
		assertEquals("project1",story.getProjectIdName());
	}
	
	@Test
	void testStory() {
		Story storyDummy = new Story();
		assertNotEquals(new Story(), storyDummy);
	}

	@Test
	void testaddStoryAssignedToUsers() {
		ArrayList<String> assginUser2 = new ArrayList<>();
		assginUser2.add("user2");
		story.addStoryAssignedToUsers("user2");
		assertEquals(assginUser2,story.getStoryAssignedToUsers());
	}

	@Test
	void testToString() {
//		fail("Not yet implemented");
	}

}
