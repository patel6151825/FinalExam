package com.johnabbott.simple.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.johnabbott.simple.model.UserEntity;

public class UserDaoImpl implements UserDao{

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_USER = "insert into " + "user(email, password) values(?, ?)";
	
	private final String SQL_SELECT_USER = "select id, email, password from user where email = ? and password=?";
	
	public UserDaoImpl(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	@Override
	public int insertUser(UserEntity user) {
		return jdbcTemplate.update(SQL_INSERT_USER, user.getEmail(), user.getPassword());
	}
	@Override
	public List<UserEntity> getUsers() {
		return jdbcTemplate.query(SQL_SELECT_USER, new UserMapper());
	}
	@Override
	public UserEntity getUserById(int userId) {
		return jdbcTemplate.queryForObject(SQL_SELECT_USER, 

				new Object[]{userId}, new UserMapper());
	}
	@Override
	public UserEntity getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
