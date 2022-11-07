package com.cts.projectmanagementportalbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Role;
import com.cts.projectmanagementportalbackend.service.RoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1.0/role")
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')") //authorizes the user before calling the method and authorizes based on the incoming arguments
	@GetMapping("/getRoles")
	public List<Role> getRoles(){
		return roleService.getRoles();
	}
	
	@PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
	@GetMapping("/getRoleById/{userId}")
	public Role getRoleById(@PathVariable int userId) throws NoSuchElementExistException{
		return roleService.getRoleById(userId);
	}
	
	@GetMapping("/getRole/search")
	@PostAuthorize("returnObject.body.userName==authencated.user") //helps you authorize based on the data that is being returned
	public ResponseEntity<Role> getRole(Authentication authentication, @RequestParam String userName) throws NoSuchElementExistException{
		Role Role = roleService.getRoleByUserName(userName);
		if(Role==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok().body(Role);
	}
	
	@PostAuthorize("returnObject.body.userName==authencated.user")
	@GetMapping("/getRoleByUserName/{userName}")
	public Role getRoleByUserName(@PathVariable String userName)  throws NoSuchElementExistException{
		return roleService.getRoleByUserName(userName);
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<Role> loginAdmin(@Valid @RequestBody Role Role) {
		return new ResponseEntity<>(roleService.loginAdmin(Role),HttpStatus.OK);
	}
	
	@PostMapping("/loginUser")
	public Role loginUser(@Valid @RequestBody Role Role) {
		return roleService.loginUser(Role);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Role> login(@Valid @RequestBody Role Role, Authentication auth)  throws NoSuchElementExistException {
		return ResponseEntity.status(HttpStatus.OK).body(roleService.login(Role));
	}
	
}
