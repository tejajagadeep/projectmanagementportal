package com.cts.projectmanagementportalbackend.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.exception.NoSuchElementExistException;
import com.cts.projectmanagementportalbackend.exception.PasswordIncorrectException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.model.Role;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.repository.RoleRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@Autowired
//	TokenService tokenService;
	

	@Override
	public User login(String userName, String password) throws PasswordIncorrectException {
		
		User user = userRepository.findByUserName(userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("userId is Invalid. please try again...");
		} else if(password == userRepository.findByUserName(userName).getPassword()) {
			throw new PasswordIncorrectException("password is incorrect. please try again...");
		}
		
		return user;
	}

	@Override
	public UserResponse loginUser(String userId, String password)  throws InvalidUserIdOrPasswordException{
		// TODO Auto-generated method stub
		UserResponse response = new UserResponse();
		User user = userRepository.findByUserName(userId);
		try {
			
			if(user!=null) {
				if (user.getPassword().equals(password)) {
					response.setUser(user);
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
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId){
		
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(optionalUser.isPresent()) {
			return userRepository.findById(userId).get();
		} else {
			throw new UsernameNotFoundException("User Id doesn't Exist");
		}
		
		
	}
	
	@Override
	public User saveUser(User user)  throws InvalidUserIdOrPasswordException{
		// TODO Auto-generated method stub
		User optionalUser = userRepository.findByUserName(user.getUserName());
//		User optionalUserEmail = userRepository.findByEmailAddress(user.getEmailAddress());
		
		if(optionalUser==null) {
			
			Role role = new Role();
			
				role.setUserName(user.getUserName());
				role.setPassword(passwordEncoder.encode(user.getPassword()));
				role.setRole(user.getRole());
			
				roleRepository.save(role);
				
			return userRepository.save(user);
//		} else if (optionalUserEmail==null) {
//			throw new ElementAlreadyExistException("Email address already Exists");
		
		} else {
			throw new InvalidUserIdOrPasswordException("User Id already Exists");
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
