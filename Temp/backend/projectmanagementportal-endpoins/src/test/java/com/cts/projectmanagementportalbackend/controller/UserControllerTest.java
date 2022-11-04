package com.cts.projectmanagementportalbackend.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.service.UserService;
import com.cts.projectmanagementportalbackend.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = UserController.class)
//@WebAppConfiguration()
@SpringBootTest
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private UserService userService;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	int randomServerPort;
	
	String dateString = "1999/07/28";
	Date date = new Date(dateString);
	private List<User> userList;
	
//	@BeforeEach
//	public void setUp() {
//		this.userList = new ArrayList<>();
//		
//		this.userList.add(new User("venkat","Venkat","venkat@gmail.com",7894561230L,date,"Member","Venkat@123"));
//		this.userList.add(new User("rajini","Rajini","rajini@gmail.com",7894561231L,date,"Admin","Rajini@123"));
//		this.userList.add(new User("vinay","Vinay","vinay@gmail.com",7894561232L,date,"Admin","Vinay@123"));
//	}
	
	@Test 
	void testsaveUser1() throws Exception {
		User user = new User("rajini","Rajini","rajini@gmail.com",7894561231L,date,"Admin","Rajini@123");
		
		mockMvc.perform(post("/api/v1.0/user/userSignUp").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isCreated())
				.andDo(print())
				;
		
	}
	
	@Test
	public void testsaveUser() throws URISyntaxException {
		
//		RestTemplate restTemplate = new RestTemplate();
		
		final String baseURL = "http://localhost:"+randomServerPort+"/project-management/api/v1.0/user/userSignUp";
		
		URI uri = new URI(baseURL);
		
		User user = new User("vinay","Vinay","vinay@gmail.com",7894561232L,date,"Admin","Vinay@123");
		
		HttpHeaders headers = new HttpHeaders();
		
		
		ResponseEntity<User> response = restTemplate.postForEntity(uri, user, User.class);
		
		assertEquals(201, response.getStatusCode());
		
	}
	
//	@Test 
//	public void testgetAllUsers() {
//		
//		when(userService.getAllUsers()).thenReturn(userList);
//		this.mockMvc.perform(get("/api/v1.0/user/getAllUsers"))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath(expression, matcher))
//			)
//
//	}
//
//	@InjectMocks
//	private UserController usercontroller;
//	
//	@Autowired
//	private TestRestTemplate restTemplate;
//	
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private WebApplicationContext context;
//	
//	ObjectMapper objectMapper = new ObjectMapper();
//	
//	private static final String User_URL = "/api/v1.0/user";
//	
//	String dateString = "1999/07/28";
//	Date date = new Date(dateString);
//
////	User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");
//	
//	@Test
//	public void testsaveUser() {
//		
//		mockMvc.perform(post("/api/v1.0/user/userSignUp")
//				.content(MediaType.APPLICATION_JSON)
//				.andExpe
//				)
//	;
//		
//		when(userService.saveUser(user)).
//		
//	}
//	
//	@BeforeEach
//	public void setUp() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}

//	@Test
//	public void testsaveUser() throws Exception {
//		User user1 = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
//		
//		String JsonRequest = objectMapper.writeValueAsString(user1);
//		
//		MvcResult result = mockMvc.perform(post("/api/v1.0/user/userSignUp").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isCreated()).andReturn();
//		
//		String resultContext = result.getResponse().getContentAsString();
//		
//		User response  = objectMapper.readValue(resultContext, User.class);
//		
////		assertTrue(response.getName()=="jagadep");
//		assertEquals("jagadep",response.getUserId());
//		
//	}
//	
//	@Test
//	public void testgetAllUser() throws Exception {
//		User user1 = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
//		
//		String JsonRequest = objectMapper.writeValueAsString(user1);
//		
//		MvcResult result = mockMvc.perform(post("/api/v1.0/user/getAllUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk()).andReturn();
//		
//		String resultContext = result.getResponse().getContentAsString();
//		
//		User response  = objectMapper.readValue(resultContext, User.class);
//		
//		assertTrue(response.getName()=="jagadep");
//		
//	}
//	
//	@Test
//	public void tesgetUserById() throws Exception {
//		User user1 = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,date,"ADMIN","789456123");
//		
//		String JsonRequest = objectMapper.writeValueAsString(user1);
//		
//		MvcResult result = mockMvc.perform(post("/api/v1.0/user/userSignUp").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isCreated()).andReturn();
//		
//		String resultContext = result.getResponse().getContentAsString();
//		
//		User response  = objectMapper.readValue(resultContext, User.class);
//		
//		assertTrue(response.getName()=="jagadep");
//		
//	}

//	
//	@Test
//	void testSaveUser() throws JSONException {
//		
//		String response = this.restTemplate.getForObject("/getAllUsers", String.class);
//		
//		JSONAssert.assertEquals("[{\"userId\":\"venkat\",\"name\":\"Venkat\",\"emailAddress\":\"venkat@gamil.com\",\"contactNo\":7894561230,\"dateOfBirth\":\"1978-07-26T18:30:00.000+00:00\",\"userType\":\"Member\",\"password\":\"Venkat@123\"},{\"userId\":\"rajini\",\"name\":\"Rajini\",\"emailAddress\":\"rajini@gamil.com\",\"contactNo\":7894561231,\"dateOfBirth\":\"1968-07-31T18:30:00.000+00:00\",\"userType\":\"Admin\",\"password\":\"Rajini@123\"},{\"userId\":\"vinay\",\"name\":\"Vinay\",\"emailAddress\":\"vinay@gamil.com\",\"contactNo\":7894561232,\"dateOfBirth\":\"1987-12-18T18:30:00.000+00:00\",\"userType\":\"Admin\",\"password\":\"Vinay@123\"}]", response, false);
//	}

//	@Test
//	public void helloWorld_basic() throws Exception {
//		//call GET "/hello-world"  application/json
//		
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/hello-world")
//				.accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string("Hello World"))
//				.andReturn();
//	
//		//verify "Hello World"
//		//assertEquals("Hello World", result.getResponse().getContentAsString());
//	}

//	@Test
//	void testHelloWorldPathVaraible() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testGetAllUsers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllUsersString() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testSaveUser() throws Exception {
//		User userObject = new User("jagadep","jagadep","jagadeep@gmail.com",78945612310L,"date","ADMIN","789456123");
//		when(userService.saveUser(ArgumentMatchers.any())).thenReturn(userService.saveUser(userObject));
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String userJson = objectMapper.writeValueAsString(userObject);
//		
//		MockHttpServletRequestBuilder mockHttpServletRequestBuilders = MockMvcRequestBuilders.post("/api/user/userSignUp").accept(MediaType.APPLICATION_JSON).content(userJson);
//		
//		ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilders);
//		
//		MvcResult mvcResult = resultActions.andReturn();
//		
//		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//		
//		int status = mockHttpServletResponse.getStatus();
//		
//		assertEquals(201, status);
//	}

}
