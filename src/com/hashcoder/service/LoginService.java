package com.hashcoder.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.database.LoginDB;
import com.hashcoder.database.UserDB;
import com.hashcoder.model.Login;
import com.hashcoder.model.User;

@Component
public class LoginService {

	@Autowired
	LoginDB loginDB;
	
	@Autowired
	UserDB userDB;
	
	public Boolean checkCredentials(Login login) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Boolean status = false;
		
		
		status = loginDB.checkCredentials(login.getEmail(), login.getPassword());

		
		if(status == false) 	
			return false;
		else	
			return true;
		
		
	}

	public Login getLoginDetails(Login login) throws ClassNotFoundException, SQLException {
		return loginDB.getLoginDetails(login);
	}

	public void registerUser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		userDB.insertUser(user);
	}

}
