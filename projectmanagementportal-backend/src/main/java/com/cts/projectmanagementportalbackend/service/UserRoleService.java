package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.UserRole;

public interface UserRoleService {

	UserRole loginAdmin(@Valid UserRole userRole);

	UserRole loginUser(@Valid UserRole userRole);

	List<UserRole> getUserRoles();

	UserRole getUserRoleById(int userId)  throws NoSuchElementExistException;

	UserRole getUserRoleByUserName(String userName)  throws NoSuchElementExistException;

	UserRole login(@Valid UserRole userRole) throws NoSuchElementExistException ;

}
