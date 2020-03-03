package com.hashcoder.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.database.HealthProffesionalDB;
import com.hashcoder.model.HealthProffesional;

@Component
public class HealthProffesionalService {

	@Autowired
	HealthProffesionalDB healthProffesionalDB;
	
	public HealthProffesional getHealthProffesionalDById(int c_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return healthProffesionalDB.getHealthProffesionalDById(c_id);
	}

}
