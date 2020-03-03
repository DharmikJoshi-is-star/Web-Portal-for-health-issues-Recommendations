package com.hashcoder.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Post {

	private Integer id;
	
	private Integer user_id;
	
	private String post;
	
	private Float avg_rating;
	
	private Integer rating_count;
	
	private Date date;
	
	private Time time;
	
	private List<Rating> ratings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Float getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(Float avg_rating) {
		this.avg_rating = avg_rating;
	}

	public Integer getRating_count() {
		return rating_count;
	}

	public void setRating_count(Integer rating_count) {
		this.rating_count = rating_count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
}
