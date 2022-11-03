package com.cts.projectmanagementportalbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	public boolean hasUserId(Authentication authentication, Integer userId) {
		
		int userID = userRoleRepository.findByUserName(authentication.getName()).getUserId();
		
		if(userID == userId) {
			return true;
		}
		
		return false;
		
	}
	
}
