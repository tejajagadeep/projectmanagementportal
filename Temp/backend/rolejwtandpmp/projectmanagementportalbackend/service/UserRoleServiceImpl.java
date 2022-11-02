package com.cts.projectmanagementportalbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserRoleRepository userRoleRepository;

}
