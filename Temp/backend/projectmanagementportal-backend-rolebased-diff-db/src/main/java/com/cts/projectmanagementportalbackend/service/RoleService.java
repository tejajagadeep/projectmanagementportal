package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.Role;

public interface RoleService {

	Role loginAdmin(@Valid Role Role);

	Role loginUser(@Valid Role Role);

	List<Role> getRoles();

	Role getRoleById(int userId)  throws NoSuchElementExistException;

	Role getRoleByUserName(String userName)  throws NoSuchElementExistException;

	Role login(@Valid Role Role) throws NoSuchElementExistException ;

}
