package com.hashcoder.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashcoder.enums.UserTypeEnum;
import com.hashcoder.model.Disease;
import com.hashcoder.model.Login;
import com.hashcoder.model.User;

@Component
public class UserDB extends DBSetup{

	@Autowired
	User user;
	
	@Autowired
	QueryDB queryDB;
	
	@Autowired
	DiseaseDB diseaseDB;
	
	@Autowired
	LoginDB loginDB;
	
	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "INSERT INTO user (name , contact , address , age , gender , email , password )VALUES (?, ?, ?,?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getContact());
		pstmt.setString(3, user.getAddress());
		pstmt.setInt(4, user.getAge());
		pstmt.setString(5, "Male");
		pstmt.setString(6, user.getEmail());
		pstmt.setString(7, user.getPassword());
		
		pstmt.executeUpdate();
		
		dbClose();
		
		dbConnect();
		
		sql = "Select id from user where email=? AND password=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getEmail());
		pstmt.setString(2, user.getPassword());
		
		
		ResultSet rst = pstmt.executeQuery();
	
		while(rst.next()) {
			user.setId(rst.getInt("id"));
			break;
		}
		
		Login login = new Login();
		login.setC_id(user.getId());
		login.setEmail(user.getEmail());
		login.setPassword(user.getPassword());
		login.setType(UserTypeEnum.USER.toString());
		
		loginDB.insertLogin(login);
		dbConnect();
		insertUserDisease(user);
		dbConnect();
		insertUserValues(user);
		
		dbClose();
		
	}
	
	private void insertUserValues(User user) throws SQLException, ClassNotFoundException {
		dbConnect();
		String sql = "INSERT INTO user_values "
					+ "(user_id, rating, rating_count, followers, following, posts, answers) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		pstmt.setFloat(2, 0.0f);
		pstmt.setInt(3, 0);
		pstmt.setInt(4, 0);
		pstmt.setInt(5, 0);
		pstmt.setInt(6, 0);
		pstmt.setInt(7, 0);
		
		pstmt.executeUpdate();
		dbClose();
	}

	private void insertUserDisease(User user) throws SQLException, ClassNotFoundException {
		
		dbConnect();
		
		if(user.getDiseases()==null)
			return;
		
		List<Disease> diseases = user.getDiseases();
		
		for (Disease disease : diseases) {
			
			String sql = "INSERT INTO user_disease (user_id, disease_id) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, disease.getId());
			pstmt.executeUpdate();
		
		}
		
		dbClose();
	}

	public User getUserById(int c_id) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		User user = new User();
		String sql = "select * from user where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, c_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			
			user.setId(rst.getInt("id"));
			user.setName(rst.getString("name"));
			user.setEmail(rst.getString("email"));
			user.setContact(rst.getString("contact"));
			user.setPassword(rst.getString("password"));
			user.setAge(rst.getInt("age"));
			user.setGender(rst.getString("gender"));
			user.setAddress(rst.getString("address"));
			
		}
		
		dbClose();
		return user;
		
	}
	
	public User getUserValues(User user) throws ClassNotFoundException, SQLException {
		

		dbConnect();
	
		String sql = "select * from user_values where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			
			user.setRating(rst.getFloat("rating"));
			user.setRatingCount(rst.getInt("rating_count"));
			user.setFollowersCount(rst.getInt("followers"));
			user.setFollowingCount(rst.getInt("following"));
			user.setPostCount(rst.getInt("posts"));
			user.setAnswerCount(rst.getInt("answers"));
			
		}
		
		dbClose();
		return user;
		
	}
	
	public User getDisease(User user) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from user_disease where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		
		List<Integer> diseaseIds = new ArrayList<Integer>();
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
		
			diseaseIds.add(rst.getInt("disease_id"));
		}
		
		dbClose();
		
		List<Disease> diseases = new ArrayList<Disease>();
		
		for (Integer integer : diseaseIds) {
			
			diseases.add(diseaseDB.getDiseaseById(integer));
		}
		
		user.setDiseases(diseases);
		
		return user;
	}
	
	public User getFollowers(User user) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from user_relation where following_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		
		List<Integer> followingtoUser = new ArrayList<Integer>();
		
		ResultSet rst = pstmt.executeQuery();
		System.out.println("User id is "+user.getId());
		
		while(rst.next()) {
			System.out.println("Result ser id "+rst.getInt("follower_id"));
			
			followingtoUser.add(rst.getInt("follower_id"));
		}
		
		dbClose();
		
		List<User> followers = new ArrayList<User>();
		
		for (Integer integer : followingtoUser) {
			System.out.println("INtegre "+integer);
			User temp = getUserById(integer);
			System.out.println("Temp user name is "+temp.getName());
			temp = getUserValues(temp);
			followers.add(temp);
			
		}
		
		user.setFollowers(followers);
		
		System.out.println("Function end "+user.getName());
		
		return user;
	}

	public User getFollowings(User user) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from user_relation where follower_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println("User.getId "+user.getId());
		pstmt.setInt(1, user.getId());
		
		List<Integer> followertoUser = new ArrayList<Integer>();
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			
			System.out.println(rst.getInt("following_id"));
			followertoUser.add(rst.getInt("following_id"));
		}
		
		dbClose();
		
		List<User> followings = new ArrayList<User>();
		
		for (Integer integer : followertoUser) {
				followings.add(getUserById(integer));

		}
		
		user.setFollowing(followings);
		
		for (User user2 : followings) {
			System.out.println(user2.getName());
		}
		
		return user;
	}
	

	public void updateRatingOfUser(int user_id, int rating) throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql = "select * from user_values where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		Float avg_rating = 0.0f;
		Integer rating_count=0;
		
		
		while(rst.next()) {
			
			avg_rating = rst.getFloat("rating");
			rating_count = rst.getInt("rating_count");
			
		}
		
		avg_rating = (rating_count+rating)/2.0f;
		rating_count++;
		
		 sql = "update user_values set rating=? , rating_count=? where user_id=?";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setFloat(1, avg_rating);
		 pstmt.setInt(2, rating_count);
		pstmt.setInt(3, user_id);
		
		pstmt.executeUpdate();
	}

	public void insertFollowOtherUser(int user_id, int otherUser_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		dbConnect();
		
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
	
        Time time = new Time(millis);
		dbConnect();
		
		String sql = "INSERT INTO user_relation (following_id, follower_id, date, time) VALUES (? , ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, otherUser_id);
		pstmt.setInt(2, user_id);
		pstmt.setDate(3, date);
		pstmt.setTime(4,time);
		
		pstmt.executeUpdate();
		
		updateFollowerValue(user_id, otherUser_id);
		
	}

	private void updateFollowerValue(int user_id, int otherUser_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dbConnect();
		
		String sql = "select following from user_values where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		ResultSet rst = pstmt.executeQuery();
		Integer following=0;
		
		while(rst.next()) {
			following = rst.getInt("following");
		}
		
		following++;
		
		sql = "update user_values set following=? where user_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, following);
		pstmt.setInt(2, user_id);
		
		pstmt.executeUpdate();
		

		sql = "select followers from user_values where user_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, otherUser_id);
		rst = pstmt.executeQuery();
		Integer followers=0;
		
		while(rst.next()) {
			followers = rst.getInt("followers");
		}
		
		followers++;
		
		sql = "update user_values set followers=? where user_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, followers);
		pstmt.setInt(2, otherUser_id);
		
		pstmt.executeUpdate();
		
	}

	public void updateUserQuestions(int user_id) throws SQLException, ClassNotFoundException {
		
			dbConnect();
		
			String sql = "select * from user_values where user_id=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			
			ResultSet rst = pstmt.executeQuery();
			
			Integer posts = 0;
			
			while(rst.next()) {
				posts = rst.getInt("posts");
			}
			
			posts++;
			
			sql = "update user_values SET posts=? where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, posts);
			pstmt.setInt(2, user_id);
			
			pstmt.executeUpdate();
			
		}

	public void updateAnswerValue(int user_id) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		String sql = "select * from user_values where user_id=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		
		ResultSet rst = pstmt.executeQuery();
		
		Integer answers = 0;
		
		while(rst.next()) {
			answers = rst.getInt("answers");
		}
		
		answers++; 
		
		sql = "update user_values SET answers=? where user_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setFloat(1, answers);
		pstmt.setInt(2, user_id);
		
		pstmt.executeUpdate();
		dbClose();
		
		
	}
		
	
}
