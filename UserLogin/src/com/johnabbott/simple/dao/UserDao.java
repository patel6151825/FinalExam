package com.johnabbott.simple.dao;

import java.util.List;

import com.johnabbott.simple.model.UserEntity;

public interface UserDao {
	public int insertUser(UserEntity user); //Create
	
	public List<UserEntity> getUsers(); // Read
	
	public UserEntity getUserById(int userId); // Read
	
	public UserEntity getUserByEmail(String email); //Read
}
