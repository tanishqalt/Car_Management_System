package com.humber.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.humber.demo.model.User;
import com.humber.demo.repository.UserRepository;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void newUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User getUserbyID(long id) {
		Optional <User> optional = userRepository.findById(id);
		User user = null;
		
		if(optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException("User not found for id: "+id);
		}
		return user;
	}

	@Override
	public User getUserbyEmail(String email) {
		
		Optional <User> optional = Optional.ofNullable(userRepository.findByEmail(email));
		User user = null;
		
		if(optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException("User not found for email: "+email);
		}
		
		return user;
	}

}
