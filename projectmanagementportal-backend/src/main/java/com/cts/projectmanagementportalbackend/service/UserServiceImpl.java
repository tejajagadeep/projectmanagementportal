package com.cts.projectmanagementportalbackend.service;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;
import com.cts.projectmanagementportalbackend.exception.IdAlreadyExistException;
import com.cts.projectmanagementportalbackend.exception.InvalidUserException;
import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	
	
	/*
	 * Retrieve All User Details
	 */
	@Override
	public List<User> getAllUsers() {
		log.info("inside get all users");
		return userRepository.findAll();
	}

	/*
	 * Retrieve User By User Id
	 */
	@Override
	public User getByUserName(String userName){
		
		User optionalUser = userRepository.findByUserName(userName);

		Optional.ofNullable(optionalUser).orElseThrow(()->new InvalidUserException("User Id doesn't exists"));
		log.info("users" + optionalUser);
		return optionalUser;
		
		
	}
	
	/*
	 * Retrieve User By Name
	 */
	@Override
	public User getUserByName(String name) {
		
		User optionalUser = userRepository.findByName(name);
		
		if(optionalUser==null ) {
			
			log.warn("user name " +name+" doesn't exist");
			throw new InvalidUserException("User name doesn't Exist.");
		}
		log.info("users" + optionalUser);
		return optionalUser;
		
	}

	/*
	 * Sign Up User
	 */
	@Override
	public User saveUser(User user){

		User optionalUser = userRepository.findByUserName(user.getUserName());
		User optionalUserEmail = userRepository.findByEmailAddress(user.getEmailAddress());

		if(optionalUser!=null) {
					log.warn("user Id already exist");
					throw new IdAlreadyExistException("User Id already Exists.");
		}
			if (optionalUserEmail!=null) {
				log.warn("Email address already exist");
				throw new IdAlreadyExistException("Email address already Exists.");
			}


			log.info("saved user " + user);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);


	}


}
