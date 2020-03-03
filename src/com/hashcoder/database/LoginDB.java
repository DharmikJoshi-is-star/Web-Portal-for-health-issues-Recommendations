package com.hashcoder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.hashcoder.model.Login;


@Component
public class LoginDB extends DBSetup{


	public Boolean checkCredentials(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int count = 0;
		dbConnect();
		String sql = "select * from login where email=? AND password=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()){ 
			count = 1;
		}
		
		if(count==1)
				return true;
		
		dbClose();
		
		return false;
	}

	public Login getLoginDetails(Login login) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		String sql = "select * from login where email=? AND password=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, login.getEmail());
		pstmt.setString(2, login.getPassword());
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()){ 
			
			login.setId(rst.getInt("id"));
			login.setC_id(rst.getInt("c_id"));
			login.setEmail(rst.getString("email"));
			login.setPassword(rst.getString("password"));
			login.setType(rst.getString("type"));
			
		}
		
		dbClose();
		
		return login;
	
	}

	public void insertLogin(Login login) throws SQLException, ClassNotFoundException {
		dbConnect();
		
		String sql = "INSERT INTO login (c_id, email, password, type) VALUES (?, ?, ?, ?)";
		
		System.out.println(login.getC_id()+login.getEmail()+login.getPassword()+login.getType());
		
		System.out.println(sql);
		
		System.out.println(con);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, login.getC_id());
		pstmt.setString(2, login.getEmail());
		pstmt.setString(3, login.getPassword());
		pstmt.setString(4, login.getType());
		
		System.out.println(sql);
		
		pstmt.executeUpdate();
		dbClose();
		
	}

	
}
