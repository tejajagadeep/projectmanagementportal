package com.cts.projectmanagementportalbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.service.UserRoleService;

@RestController
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	
	
}
