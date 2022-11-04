package com.cts.projectmanagementportalbackend.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.ElementAlreadyExistException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.model.UserRole;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) throws NoSuchElementExistException {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(optionalUser.isPresent()) {
			return userRepository.findById(userId).get();
		} else {
			throw new NoSuchElementExistException("User Id doesn't Exist");
		}
		
		
	}
	
	@Override
	public User saveUser(User user)  throws ElementAlreadyExistException{
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(user.getUserId());
//		User optionalUserEmail = userRepository.findByEmailAddress(user.getEmailAddress());
		
		if(optionalUser.isEmpty()) {
			
			UserRole userRole = new UserRole();
			
				userRole.setUserName(user.getUserId());
				userRole.setPassword((user.getPassword()));
				userRole.setRole(user.getUserType());
			
				userRoleRepository.save(userRole);
				
			return userRepository.save(user);
//		} else if (optionalUserEmail==null) {
//			throw new ElementAlreadyExistException("Email address already Exists");
		
		} else {
			throw new ElementAlreadyExistException("User Id already Exists");
		}
		
	}



}
