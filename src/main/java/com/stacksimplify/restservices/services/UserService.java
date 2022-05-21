package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get all users method
	public  List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	//Create user method
	public User createUser( User user) {
		return userRepository.save(user);
	}
	
	//Get user by id
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}
	
	//Update user by id
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	//Delete user by id
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	//Get user by username
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
