package com.cts.projectmanagementportalbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cts.projectmanagementportalbackend.repository.RoleRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRepository userRoleRepository;
//	RoleRepository userRoleRepository;
	
	public boolean hasUserId(Authentication authentication, Integer userId) {
		
		int userID = userRoleRepository.findByUserName(authentication.getName()).getUserId();
		
		if(userID == userId) {
			return true;
		}
		
		return false;
		
	}
	
}
