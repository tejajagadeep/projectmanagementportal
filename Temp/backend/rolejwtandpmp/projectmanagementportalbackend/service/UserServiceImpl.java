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
	
//	@Autowired
//	TokenService tokenService;
	

	@Override
	public UserResponse loginUser(String userId, String password)  throws InvalidUserIdOrPasswordException{
		// TODO Auto-generated method stub
		UserResponse response = new UserResponse();
		Optional<User> user = userRepository.findById(userId);
		try {
			
			if(user!=null) {
				if (user.get().getPassword().equals(password)) {
					response.setUser(user.get());
					response.setLoginStatus("success");
					response.setErrorMessage("null");
//					response.setToken(tokenService.createToken(user.get().getUserId()));
				}
				else
					throw new InvalidUserIdOrPasswordException("Invalid Username Or Password Exception1");
			}
			else
				throw new InvalidUserIdOrPasswordException("Invalid Username Or Password Exception2");
		}
		catch (InvalidUserIdOrPasswordException invalidUsernameOrPasswordException){
			response.setLoginStatus("failed");
			response.setErrorMessage("Invalid Credentials");
			invalidUsernameOrPasswordException.printStackTrace();
		}
		return response;
	}
	
	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return userRepository.findByUserIdAndPassword(userId, password);
	}

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
		Optional<User> userOptional = userRepository.findById(user.getUserId());
		
		if(userOptional.isEmpty()) {
			
			UserRole userRole = new UserRole();
			
				userRole.setUserId(user.getUserId());
				userRole.setPassword(user.getPassword());
				userRole.setRole(user.getUserType());
			
			return userRepository.save(user);
		} else {
			throw new ElementAlreadyExistException("User Id already Exists");
		}
		
	}

	

//	@Override
//	public User loginUser(User user) {
//		// TODO Auto-generated method stub
//Optional<User> userOptional = userRepository.findById(user.getUserId());
//		
//		if(userOptional.isEmpty()) {
//			return userRepository.save(user);
//		} else {
//			throw new RuntimeException();
//		}
//	}



}
