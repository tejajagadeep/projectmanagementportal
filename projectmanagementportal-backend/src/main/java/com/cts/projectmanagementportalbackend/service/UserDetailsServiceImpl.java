package com.cts.projectmanagementportalbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.model.UserDetailsImpl;
import com.cts.projectmanagementportalbackend.model.UserRole;
import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		
		UserRole user = userRoleRepository.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username + " not found");
		} 
		
		return new UserDetailsImpl(user);
		
		
	}

}
