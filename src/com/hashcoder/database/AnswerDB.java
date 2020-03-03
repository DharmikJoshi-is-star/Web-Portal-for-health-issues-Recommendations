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
import com.hashcoder.model.Rating;

public class AnswerDB extends DBSetup{

	@Autowired
	Answer answer;
	
	@Autowired
	UserDB userDB;
	
	public List<Answer> getAnswersByQuestionId(int query_id) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from answers where query_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, query_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Answer> answers = new ArrayList<Answer>();
		
		while(rst.next()) {
			
			Answer answer = new Answer();
			
			answer.setId(rst.getInt("id"));
			answer.setUser_id(rst.getInt("user_id"));
			answer.setQuery_id(rst.getInt("query_id"));
			answer.setAnswer(rst.getString("answer"));
			answer.setAvg_rating(rst.getFloat("avg_rating"));
			answer.setRating_cout(rst.getInt("rating_count"));
			answer.setDate(rst.getDate("date"));
			answer.setTime(rst.getTime("time"));
			answer.setPerson_type(rst.getString("person_type"));
			
			answer = answerRatings(answer);
			
			answers.add(answer);
			
		}
		
		return answers;
		
	}
	
	public Answer answerRatings(Answer answer) throws ClassNotFoundException, SQLException{
		
		dbConnect();
		String sql = "select * from answers_rating where answer_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, answer.getId());
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Rating> ratingsOfAnswer =  new ArrayList<Rating>();
		
		while(rst.next()) {
			
			Rating rating = new Rating();
			
			rating.setId(rst.getInt("id"));
			rating.setContent_id(rst.getInt("answer_id"));
			rating.setId(rst.getInt("user_id"));
			rating.setRating(rst.getFloat("rating"));
			rating.setDate(rst.getDate("date"));
			rating.setTime(rst.getTime("time"));
			
			ratingsOfAnswer.add(rating);
		}
		
		answer.setRatings(ratingsOfAnswer);
		
		return answer;
	}
	
	public List<Answer> getAnswersByUserId(int user_id) throws SQLException, ClassNotFoundException{
		
		dbConnect();
		String sql = "select * from answers where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Answer> answers = new ArrayList<Answer>();
		
		while(rst.next()) {
			
			Answer answer = new Answer();
			
			answer.setId(rst.getInt("id"));
			answer.setUser_id(rst.getInt("user_id"));
			answer.setQuery_id(rst.getInt("query_id"));
			answer.setAnswer(rst.getString("answer"));
			answer.setAvg_rating(rst.getFloat("avg_rating"));
			answer.setRating_cout(rst.getInt("rating_count"));
			answer.setDate(rst.getDate("date"));
			answer.setTime(rst.getTime("time"));
			answer.setPerson_type(rst.getString("person_type"));
			
			answer = answerRatings(answer);
			
			answers.add(answer);
			
		}
		
		return answers;
		
	
	}

	public void insertRatingForAnswer(int user_id, int answer_id, int rating) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		dbConnect();
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        Time time = new Time(millis);
        
		String sql = "INSERT INTO answers_rating (user_id, answer_id, rating, date, time) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, answer_id);
		pstmt.setFloat(3, new Float(rating));
		pstmt.setDate(4, date);
		pstmt.setTime(5, time);
		
		pstmt.executeUpdate();
		
		updateValueofAnswer(answer_id, rating);
		
		userDB.updateRatingOfUser(user_id,rating);
	}

	private void updateValueofAnswer(int answer_id, int rating) throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql = "select * from answer where id=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, answer_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		
		Float avg_rating = 0.0f;
		Integer rating_count = 0;
		
		while(rst.next()) {
			avg_rating = rst.getFloat("avg_rating");
			rating_count = rst.getInt("rating_count");
		}
		
		rating_count++;
		avg_rating = (avg_rating+rating)/2.0f;
		
		sql = "update post SET avg_rating=? , rating_count=? where id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setFloat(1, avg_rating);
		pstmt.setInt(2, rating_count);
		pstmt.setInt(3, answer_id);
		
		pstmt.executeUpdate();
		
		
	}

	public void insertAnswer(int user_id, int question_id, String answer, String type) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        Time time = new Time(millis);
        
		String sql = "INSERT INTO answers (user_id, query_id, answer, avg_rating, rating_count, date, time, person_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, question_id);
		pstmt.setString(3, answer);
		pstmt.setFloat(4, 0.0f);
		pstmt.setInt(5, 0);
		pstmt.setDate(6, date);
		pstmt.setTime(7, time);
		pstmt.setString(8, type);
		
		pstmt.executeUpdate();
		
		dbClose();
		
		userDB.updateAnswerValue(user_id);
		
	}
}
