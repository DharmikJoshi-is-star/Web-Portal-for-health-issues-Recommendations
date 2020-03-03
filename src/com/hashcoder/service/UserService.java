package com.hashcoder.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.database.UserDB;
import com.hashcoder.model.User;

@Component
public class UserService {

	@Autowired
	UserDB userDB;
	
	public User getUserById(int c_id) throws ClassNotFoundException, SQLException {
		
		return userDB.getUserById(c_id);
		
	}

	
	
}
