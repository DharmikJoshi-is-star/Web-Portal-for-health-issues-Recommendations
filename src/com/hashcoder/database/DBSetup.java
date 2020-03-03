package com.hashcoder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSetup {

	protected String username = "root";
	protected String password = "";
	protected String dbName = "hashcoder";
	protected String url = "jdbc:mysql://localhost:3306/"+dbName;
	protected String driver = "com.mysql.jdbc.Driver";
	protected Connection con;
	
	protected void dbClose() throws SQLException{
		con.close();
	}
	
	protected void dbConnect() throws ClassNotFoundException, SQLException{
		//Step 2: load the driver
		Class.forName(driver);
		//Step 3: Make the connection
		con = DriverManager.getConnection(url, username, password);
	
	}
	
}
