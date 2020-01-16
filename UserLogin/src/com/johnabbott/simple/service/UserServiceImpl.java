package com.johnabbott.simple.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnabbott.simple.dao.UserDao;
import com.johnabbott.simple.model.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	@Override
	public boolean addUser(UserEntity user) {
		return userDao.insertUser(user) > 0 ;
	}

	@Override
	public List<UserEntity> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public UserEntity getUserById(int userId) {
		return userDao.getUserById(userId);
	}
	
	
}
