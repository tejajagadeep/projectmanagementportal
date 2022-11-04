package com.cts.projectmanagementportalbackend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserRole;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<UserRole> getUserRoles(){
		return userRoleRepository.findAll();
	}
	
	@Override
	public UserRole getUserRoleById(int userId) throws NoSuchElementExistException{
		
		Optional<UserRole> optional = userRoleRepository.findById(userId);
		if(optional.isPresent()) {
			return userRoleRepository.findById(userId).get();
		} else {
			throw new NoSuchElementExistException(userId + " doesn't exist");
		}
		
	}
	
	@Override
	public UserRole getUserRoleByUserName(String userName) throws NoSuchElementExistException{
		
		UserRole optional = userRoleRepository.findByUserName(userName);
		if(optional==null) {
			return userRoleRepository.findByUserName(userName);
		} else {
			throw new NoSuchElementExistException(userName + " doesn't exist");
		}
	}

	@Override
	public UserRole loginAdmin(@Valid UserRole userRole) {
		
//		Optional<User> optional = userRepository.findById(userRole.getUserId());
		
//		if(user)
		return null;
	}

	@Override
	public UserRole loginUser(@Valid UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole login(@Valid UserRole userRole) throws NoSuchElementExistException {
		// TODO Auto-generated method stub
		
		UserRole optional = userRoleRepository.findByUserName(userRole.getUserName());
		if(optional==null) {
			throw new NoSuchElementExistException("User Id doesn't exist");
			
		} else if (passwordEncoder.encode(userRole.getPassword())==optional.getPassword()){
			throw new NoSuchElementExistException("Password isn't correct");
		}
		
		return userRoleRepository.findByUserName(userRole.getUserName());
	}

}
