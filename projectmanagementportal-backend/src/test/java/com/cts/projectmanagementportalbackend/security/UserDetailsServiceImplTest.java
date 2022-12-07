package com.cts.projectmanagementportalbackend.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;


@SpringBootTest
class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	private UserRepository userRoleRepository;
	
	@Mock
	User userRole;

	@Test
	void testLoadUserByUsername() {
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("DOCTOR");
		
		User role = new User();
		
		role.setUserName("thunder");
		role.setPassword("thunder");
		role.setRole("DOCTOR");
		
		System.out.println(role.toString());
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(role);
		UserDetailsImpl userDetails = new UserDetailsImpl(role);
		UserDetails user = new UserDetailsImpl(role);
		System.out.println(userDetailsServiceImpl.loadUserByUsername("thunder").toString());
		assertEquals(user, userDetailsServiceImpl.loadUserByUsername("thunder"));
	}
	
	@Test
	void testLoadUserByUsernameException() {
		userRole.setUserName("thunder");
		userRole.setPassword("thunder");
		userRole.setRole("DOCTOR");
		
		when(userRoleRepository.findByUserName("thunder")).thenReturn(null);
		UserDetailsImpl userDetails = new UserDetailsImpl(userRole);
		assertThrows(UsernameNotFoundException.class, ()->userDetailsServiceImpl.loadUserByUsername("thunder"));
	}

}