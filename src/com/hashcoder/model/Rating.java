package com.hashcoder.model;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class Rating {

	private Integer id;
	
	private Integer user_id;
	
	private Integer content_id;
	
	private Float rating;
	
	private Date date;
	
	private Time time;

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

	public Integer getContent_id() {
		return content_id;
	}

	public void setContent_id(Integer content_id) {
		this.content_id = content_id;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
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
	
	
}
