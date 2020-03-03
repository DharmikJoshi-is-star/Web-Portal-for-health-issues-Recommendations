package com.hashcoder.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hashcoder.model.Answer;
import com.hashcoder.model.Query;

public class QueryDB extends DBSetup{

	@Autowired
	Query query;
	
	@Autowired
	AnswerDB answerDB;
	
	@Autowired
	UserDB userDB;
	
	public List<Query> getQueryByUserId(Integer user_id) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from queries where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Query> queries = new ArrayList<Query>();
		
		while(rst.next()) {
			
			Query query = new Query();
			
			query.setId(rst.getInt("id"));
			query.setUser_id(rst.getInt("user_id"));
			query.setQuery(rst.getString("query"));
			query.setDate(rst.getDate("date"));
			query.setTime(rst.getTime("time"));	
			
			query.setAnswers(answerDB.getAnswersByQuestionId(query.getId()));
			
			queries.add(query);
		}
		
		dbClose();
		
		return queries;
		
	}

	public void insertQuery(int user_id, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dbConnect();
		
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        Time time = new Time(millis);
		
		String sql = "INSERT INTO queries ( user_id, query, date, time) VALUES ( ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, query);
		pstmt.setDate(3, date);
		pstmt.setTime(4, time);
		
		pstmt.executeUpdate();
		
		userDB.updateUserQuestions(user_id);
		
	}

	public List<Query> getAll() throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from queries";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Query> queries = new ArrayList<Query>();
		
		while(rst.next()) {
			
			Query query = new Query();
			
			query.setId(rst.getInt("id"));
			query.setQuery(rst.getString("query"));
			query.setDate(rst.getDate("date"));
			query.setTime(rst.getTime("time"));
			query.setUser_id(rst.getInt("user_id"));
			
			query.setAnswers(answerDB.getAnswersByQuestionId(query.getId()));
			
			
			queries.add(query);
			
		}
		
		for (Query query : queries) {
			System.out.println("============================");
			System.out.println(query.getQuery());
			for (Answer ans :query.getAnswers()) {
				System.out.println(ans.getAnswer());
			}
		}
		
		dbClose();
		
		return queries;
	}
	


	
}
