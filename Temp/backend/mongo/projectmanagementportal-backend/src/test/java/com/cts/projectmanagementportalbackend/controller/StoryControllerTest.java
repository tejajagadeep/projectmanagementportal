package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.projectmanagementportalbackend.model.MessageResponse;
import com.cts.projectmanagementportalbackend.model.Story;
import com.cts.projectmanagementportalbackend.service.StoryService;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class StoryControllerTest {

	@InjectMocks
	StoryController storyController;

	@Mock
	StoryService storyService;

	List<Story> storyList;
	Story story;
	MessageResponse messageResponse;
	
	@Test
	@Order(1)
	void testGetAllStories() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		storyList = new ArrayList<>();
		storyList.add(new Story("story1", "project1", "story1", storyDescriptionDummy, "assignee", "assignee@gmail.com",
				date, date, "Completed", "Completed"));
		storyList.add(new Story("story2", "project1", "story2", storyDescriptionDummy, "assignee", "assignee@gmail.com",
				date, date, "Completed", "Completed"));

		when(storyService.getAllStories()).thenReturn(storyList);
		ResponseEntity<List<Story>> response = storyController.getAllStories();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, response.getBody().size());
	}

	@Test
	@Order(2)
	void testGetStoryById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		story = new Story("story2", "project1", "story2", storyDescriptionDummy, "assignee", "assignee@gmail.com", date,
				date, "Completed", "Completed");

		when(storyService.getStoryById("story2")).thenReturn(story);
		ResponseEntity<Story> response = storyController.getStoryById("story2");

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	@Order(3)
	void testSaveStory() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		story = new Story("story2", "project1", "story2", storyDescriptionDummy, "assignee", "assignee@gmail.com", date,
				date, "Completed", "Completed");

		when(storyService.saveStory(story)).thenReturn(story);
		ResponseEntity<Story> response = storyController.saveStory(story);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	@Test
	@Order(4)
	void testUpdateStoryByIdAdmin() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		story = new Story("story2", "project1", "story2", storyDescriptionDummy, "assignee", "assignee@gmail.com", date,
				date, "Completed", "Completed");

		when(storyService.updateStoryAdmin("story2", story)).thenReturn(story);
		ResponseEntity<Story> response = storyController.updateStoryByIdAdmin("story2", story);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(5)
	void testAssign() {
		messageResponse = new MessageResponse(new Date(), "abc",HttpStatus.OK);
		ResponseEntity<MessageResponse> response = storyController.assign("project1", "story1");
		storyService.assign("project1", "story1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(6)
	void testAssignStoryToUsers() {
		messageResponse = new MessageResponse(new Date(), "abc",HttpStatus.OK);
		ResponseEntity<MessageResponse> response = storyController.assignStoryToUsers("user1", "story1");
		storyService.assignStoryToUser("user1", "story1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(7)
	void testDeleteStoryById() {
		String dateString = "1999/07/28";
		Date date = new Date(dateString);
		String storyDescriptionDummy = "As Bean Validation API is just a specification, it requires an implementation. So, for that, it uses Hibernate Validator. The Hibernate Validator is a fully compliant.";

		storyList = new ArrayList<>();
		storyList.add(new Story("story1", "project1", "story1", storyDescriptionDummy, "assignee", "assignee@gmail.com",
				date, date, "Completed", "Completed"));
		storyList.add(new Story("story2", "project1", "story2", storyDescriptionDummy, "assignee", "assignee@gmail.com",
				date, date, "Completed", "Completed"));
		
		ResponseEntity<List<Story>> response = storyController.deleteStoryById("story1");
		storyService.deleteStoryById("story1");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
