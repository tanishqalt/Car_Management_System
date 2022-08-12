package com.humber.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.demo.model.Admin;
import com.humber.demo.model.Car;
import com.humber.demo.model.User;
import com.humber.demo.repository.AdminRepository;
import com.humber.demo.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Admin getAdmin(String username, String password) {
		
		Optional <Admin> optional = Optional.ofNullable(adminRepository.findAdmin(username, password));
		Admin admin = null;
		
		if(optional.isPresent()) {
			admin = optional.get();
		} else {
			throw new RuntimeException("User not found for email: "+username);
		}
		
		return admin;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	
}
