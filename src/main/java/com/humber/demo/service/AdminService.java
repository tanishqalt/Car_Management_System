package com.humber.demo.service;

import java.util.List;

import com.humber.demo.model.Admin;
import com.humber.demo.model.User;

public interface AdminService {
	Admin getAdmin(String username, String password);

	List<User> getAllUsers();
}
