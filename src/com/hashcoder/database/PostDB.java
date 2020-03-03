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

import com.hashcoder.model.Post;
import com.hashcoder.model.Rating;
import com.hashcoder.model.User;

@Component
public class PostDB extends DBSetup{

	@Autowired
	UserDB userDB;
	
	public User getPostsByUser(User user) throws ClassNotFoundException, SQLException{
		
		List<Post> postsByUser = new ArrayList<Post>();
		List<Integer> idsOfPost = new ArrayList<Integer>();
		
		dbConnect();
		
		String sql = "select * from post where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			idsOfPost.add(rst.getInt("id"));
		}
		
		dbClose();
		
		for (Integer integer : idsOfPost) {
			postsByUser.add(getPostById(integer));
		}
		
		user.setPosts(postsByUser);
		
		return user;
	}
	
	
	public Post getPostById(Integer pid) throws ClassNotFoundException, SQLException {
		
		
		dbConnect();
		
		String sql = "select * from post where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, pid);
		
		ResultSet rst = pstmt.executeQuery();
		
		Post post = new Post();
		
		while(rst.next()) {
			
			post.setId(rst.getInt("id"));
			post.setUser_id(rst.getInt("user_id"));
			post.setPost(rst.getString("post"));
			post.setAvg_rating(rst.getFloat("avg_rating"));
			post.setRating_count(rst.getInt("rating_count"));
			post.setDate(rst.getDate("date"));
			post.setTime(rst.getTime("time"));
			
		}
		
		dbClose();
		
		return post;
	}
	
	public Post postRating(Post post) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		String sql = "select * from post_rating where post_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, post.getId());
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Rating> ratingsOfPost =  new ArrayList<Rating>();
		
		while(rst.next()) {
		
			Rating rating = new Rating();
			
			rating.setId(rst.getInt("id"));
			rating.setContent_id(rst.getInt("post_id"));
			rating.setId(rst.getInt("user_id"));
			rating.setRating(rst.getFloat("rating"));
			rating.setDate(rst.getDate("date"));
			rating.setTime(rst.getTime("time"));
			
			ratingsOfPost.add(rating);
		}
		
		
		
		post.setRatings(ratingsOfPost);
		
		return post;
	}


	public void insertRating(int user_id, int post_id, int rating) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dbConnect();
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
	
        Time time = new Time(millis);
		String sql = "INSERT INTO post_rating(post_id, user_id, rating, date, time) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, post_id);
		pstmt.setInt(2, user_id);
		pstmt.setFloat(3, new Float(rating));
		pstmt.setDate(4, date);
		pstmt.setTime(5, time);
		
		pstmt.executeUpdate();
		
		updateValueofPost(post_id, rating);
		
		userDB.updateRatingOfUser(user_id,rating);
		
	}



	private void updateValueofPost(int post_id, int rating) throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql = "select * from post where id=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, post_id);
		
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
		pstmt.setInt(3, post_id);
		
		pstmt.executeUpdate();
		
	}


	public void insertPost(Post post,Integer user_id) throws ClassNotFoundException, SQLException {
		
		dbConnect();
		
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);
        Time time = new Time(millis);
		
		String sql = "INSERT INTO post (user_id, post, avg_rating, rating_count, date, time) VALUES ( ?,?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, post.getPost());
		pstmt.setFloat(3, 0.0f);
		pstmt.setInt(4, 0);
		pstmt.setDate(5, date);
		pstmt.setTime(6, time);
		
		pstmt.executeQuery();
		
		dbClose();
		
	}


	public List<Post> getAllPost() throws SQLException, ClassNotFoundException {
		dbConnect();
		
		String sql = "select * from post";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		ResultSet rst = pstmt.executeQuery();
		
		List<Post> posts = new ArrayList<>();
		
		while(rst.next()) {
			Post post = new Post();
			post.setId(rst.getInt("id"));
			post.setUser_id(rst.getInt("user_id"));
			post.setPost(rst.getString("post"));
			post.setAvg_rating(rst.getFloat("avg_rating"));
			post.setRating_count(rst.getInt("rating_count"));
			post.setDate(rst.getDate("date"));
			post.setTime(rst.getTime("time"));
			
			post = postRating(post);
			
			posts.add(post);
		}
		
		dbClose();
		
		return posts;
	}
}
