package com.cts.projectmanagementportalbackendauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackendauth.model.MyUserDetails;
import com.cts.projectmanagementportalbackendauth.model.User;
import com.cts.projectmanagementportalbackendauth.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userRepository.findByUserName(username);
		System.out.println("inside user details Service");
		if(user==null) {
			throw new UsernameNotFoundException(username+" not found");
		}
		
		return new MyUserDetails(user);
	}

}
