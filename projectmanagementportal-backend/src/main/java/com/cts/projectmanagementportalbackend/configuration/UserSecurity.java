package com.cts.projectmanagementportalbackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
//import com.cts.projectmanagementportalbackend.repository.RoleRepository;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	UserRepository userRoleRepository;
//	RoleRepository userRoleRepository;
	
	static Logger logg = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	public boolean hasUserId(Authentication authentication, Integer userId) {
		
		int userID = userRoleRepository.findByUserName(authentication.getName()).getUserId();
		logg.info("inside hasUserId of UserSecurity. userId: "+userId+". Authication: "+authentication);
		
		if(userID == userId) {
			return true;
		}
		
		return false;
		
	}
	
}
