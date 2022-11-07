package com.cts.projectmanagementportalbackend.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.model.Role;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.RoleRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
//	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		
		User user = userRepository.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username + " not found");
		} 
		
		return new UserDetailsImpl(user);
		
		
	}

}
