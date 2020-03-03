package com.hashcoder.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.model.Answer;
import com.hashcoder.model.Disease;

@Component
public class DiseaseDB extends DBSetup{

	@Autowired
	Disease disease;
	
	public Disease getDiseaseById(Integer d_id) throws ClassNotFoundException, SQLException {
		
		Disease disease = new Disease();
		
		dbConnect();
		
		String sql = "select * from disease where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, d_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		Answer answer = new Answer();
		
		while(rst.next()) {
			
			disease.setId(rst.getInt("id"));
			disease.setName(rst.getString("name"));
			disease.setCategory(rst.getString("category"));
		}
		
		dbConnect();
		
		return disease;
	}
	
	public void insertDisease(Disease disease) {
		
		
		
	}
	
}
