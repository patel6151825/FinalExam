package com.johnabbott.simple.service;

import java.util.List;

import com.johnabbott.simple.model.UserEntity;

public interface UserService {
	public boolean addUser(UserEntity user);

	public List<UserEntity> getUsers(); // Read
	
	public UserEntity getUserById(int userId); // Read
}
