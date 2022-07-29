package com.humber.demo.service;
import com.humber.demo.model.User;

public interface UserService {
	
	// Method 1 – Save a new user - Register Method
	void newUser(User user);
	
	// Method 2 – Retrieve a single user
	User getUserbyID(long id);
	
}
