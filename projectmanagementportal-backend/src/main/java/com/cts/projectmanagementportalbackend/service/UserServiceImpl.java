package com.cts.projectmanagementportalbackend.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.model.UserResponse;
import com.cts.projectmanagementportalbackend.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
//	@Autowired
//	UserDetails userDetials;
	
	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
//	@Autowired
//	TokenService tokenService;
	

	@Override
	public User login(String userName, String password) throws InvalidUserIdOrPasswordException {
		
		log.info("inside login of userServiceImpl");
		
		User user = userRepository.findByUserName(userName);
		if(user==null) {
			log.info("userId is Invalid. please try again..."+userName);
			throw new InvalidUserIdOrPasswordException("userId is Invalid. please try again...");
		} else if (!encoder.matches(password, user.getPassword().replace("{bcrypt}", ""))) {
			log.info("password "+password+" is Invalid. please try again..."+user.getPassword().replace("{bcrypt}", "")+ " match :"+encoder.matches(password, user.getPassword()));
			throw new InvalidUserIdOrPasswordException("password is Invalid. please try again...");
		}
		log.info("usernaem : "+userName);
		
		return user;
	}
	
	@Override
	public User login1(User user) throws InvalidUserIdOrPasswordException {
		
		log.info("inside login of userServiceImpl");
		
		User userDummy = userRepository.findByUserName(user.getUserName());
//		log.info("passwordEncoder.encode(password)"+passwordEncoder.encode(password));
//		System.out.println("passwordEncoder.encode(password)"+passwordEncoder.encode(password));
		if(userDummy==null) {
			log.info("userId is Invalid. please try again..."+user.getUserName());
			throw new InvalidUserIdOrPasswordException("userId is Invalid. please try again...");
			
//		}else if (user.getPassword()!=userDetials.getPassword()) {
//			log.info("password is Invalid. please try again..."+user.getPassword());
//			throw new PasswordIncorrectException("password is Invalid. please try again...");
			
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
	public List<User> getAllUsers(String userName) {
		// TODO Auto-generated method stub
		log.info("inside get all users");
		return userRepository.findAll();
	}

	@Override
	public User getByUserName(String userName)  throws InvalidUserIdOrPasswordException{
		
		User optionalUser = userRepository.findByUserName(userName);
		
		if(optionalUser!=null ) {
			log.info("users" + optionalUser.toString());
			return optionalUser;
		} else{
			log.warn("user Id " +userName+" dosem't exist");
			throw new InvalidUserIdOrPasswordException("User Id doesn't Exist");
		}
		
		
	}
	
	@Override
	public User getByUserId(int userId)  throws InvalidUserIdOrPasswordException{
		
		User optionalUser = userRepository.findById(userId).get();
	
		if(optionalUser!=null ) {
			log.info("users" + optionalUser.toString());
			return optionalUser;
		} else{
			log.warn("user Id " +userId+" dosem't exist");
			throw new InvalidUserIdOrPasswordException("User Id doesn't Exist");
		}
		
		
	}
	
	@Override
	public User saveUser(User user)  throws InvalidUserIdOrPasswordException{
		// TODO Auto-generated method stub
		User optionalUser = userRepository.findByUserName(user.getUserName());
//		User optionalUserEmail = userRepository.findByEmailAddress(user.getEmailAddress());
		
		try {
		if(optionalUser==null) {
			log.info("saved user " +user.toString());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
//		} else if (optionalUserEmail==null) {
//			throw new ElementAlreadyExistException("Email address already Exists");
		
		} else {
			log.info("user Id alerady exist");
			throw new InvalidUserIdOrPasswordException("User Id already Exists");
		}
		} catch (InvalidUserIdOrPasswordException e) {
			log.info("catch user Id alerady exist");
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
