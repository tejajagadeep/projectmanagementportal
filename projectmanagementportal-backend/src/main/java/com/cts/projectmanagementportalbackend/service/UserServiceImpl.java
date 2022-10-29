package com.cts.projectmanagementportalbackend.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> userOptional = userRepository.findById(user.getUserId());
		
		if(userOptional.isEmpty()) {
			return userRepository.save(user);
		} else {
			throw new RuntimeException();
		}
		
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
//		return userRepository.getById(userId);
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
Optional<User> userOptional = userRepository.findById(user.getUserId());
		
		if(userOptional.isEmpty()) {
			return userRepository.save(user);
		} else {
			throw new RuntimeException();
		}
	}

}
