package com.cts.projectmanagementportalbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserIdOrPasswordException;
import com.cts.projectmanagementportalbackend.model.User;
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
	public User getUserByName(String name)  throws InvalidUserIdOrPasswordException{
		
		User optionalUser = userRepository.findByName(name);
		
		if(optionalUser!=null ) {
			log.info("users" + optionalUser.toString());
			return optionalUser;
		} else{
			log.warn("user name " +name+" dosem't exist");
			throw new InvalidUserIdOrPasswordException("User name doesn't Exist");
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
		
		User optionalUser = userRepository.findByUserName(user.getUserName());
		User optionalUserEmail = userRepository.findByEmailAddress(user.getEmailAddress());
		
		try {
		if(optionalUser==null) {
			
			userRepository.findAll().forEach(userNameEach->{
				
				if(userNameEach.getName().equalsIgnoreCase(user.getUserName())) {
					
					log.warn("user Id alerady exist");
					throw new InvalidUserIdOrPasswordException("User Id already Exists");
					
				}
			});
			
			if (optionalUserEmail!=null) {
				log.warn("Email addres alerady exist");
				throw new IdAlreadyExistException("Email address already Exists");
			}
			
			
			log.info("saved user " +user.toString());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		
		} else {
			log.warn("user Id alerady exist");
			throw new InvalidUserIdOrPasswordException("User Id already Exists");
		} }
		catch (InvalidUserIdOrPasswordException e) {
			log.warn("catch user Id alerady exist");
			throw new InvalidUserIdOrPasswordException("User Id already Exists");
		}
		
	}


	


}
