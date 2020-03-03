package com.hashcoder.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.model.HealthProffesional;

@Component
public class HealthProffesionalDB extends DBSetup{

	@Autowired
	HealthProffesional healthProffesional;
	
	public HealthProffesional getHealthProffesionalDById(int c_id) throws ClassNotFoundException, SQLException {
		dbConnect();
		
		String sql = "select * from healthproffesional where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, c_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			
			healthProffesional.setId(rst.getInt("id"));
			healthProffesional.setName(rst.getString("name"));
			healthProffesional.setEmail(rst.getString("email"));
			healthProffesional.setContact(rst.getString("contact"));
			healthProffesional.setPassword(rst.getString("password"));
			healthProffesional.setAge(rst.getInt("age"));
			healthProffesional.setGender(rst.getString("gender"));
			healthProffesional.setAddress(rst.getString("address"));
		}
		
		dbClose();
		return healthProffesional;
		
	}

	
}
