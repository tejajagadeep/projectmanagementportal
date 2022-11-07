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
import com.cts.projectmanagementportalbackend.model.Role;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import com.cts.projectmanagementportalbackend.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository RoleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Role> getRoles(){
		return RoleRepository.findAll();
	}
	
	@Override
	public Role getRoleById(int userId) throws NoSuchElementExistException{
		
		Optional<Role> optional = RoleRepository.findById(userId);
		if(optional.isPresent()) {
			return RoleRepository.findById(userId).get();
		} else {
			throw new NoSuchElementExistException(userId + " doesn't exist");
		}
		
	}
	
	@Override
	public Role getRoleByUserName(String userName) throws NoSuchElementExistException{
		
		Role optional = RoleRepository.findByUserName(userName);
		if(optional==null) {
			return RoleRepository.findByUserName(userName);
		} else {
			throw new NoSuchElementExistException(userName + " doesn't exist");
		}
	}

	@Override
	public Role loginAdmin(@Valid Role Role) {
		
//		Optional<User> optional = userRepository.findById(Role.getUserId());
		
//		if(user)
		return null;
	}

	@Override
	public Role loginUser(@Valid Role Role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role login(@Valid Role Role) throws NoSuchElementExistException {
		// TODO Auto-generated method stub
		
		Role optional = RoleRepository.findByUserName(Role.getUserName());
		if(optional==null) {
			throw new NoSuchElementExistException("User Id doesn't exist");
			
		} else if (passwordEncoder.encode(Role.getPassword())==optional.getPassword()){
			throw new NoSuchElementExistException("Password isn't correct");
		}
		
		return RoleRepository.findByUserName(Role.getUserName());
	}

}
