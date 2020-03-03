package com.hashcoder.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Answer {

	private Integer id;
	
	private Integer user_id;
	
	private Integer query_id;
	
	private String answer;
	
	private Float avg_rating;
	
	private Integer rating_cout;
	
	private Date date;
	
	private Time time;
	
	private String person_type;
	
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

	public Integer getQuery_id() {
		return query_id;
	}

	public void setQuery_id(Integer query_id) {
		this.query_id = query_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		
		this.answer = answer;
	}

	public Float getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(Float avg_rating) {
		this.avg_rating = avg_rating;
	}

	public Integer getRating_cout() {
		return rating_cout;
	}

	public void setRating_cout(Integer rating_cout) {
		this.rating_cout = rating_cout;
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

	public String getPerson_type() {
		return person_type;
	}

	public void setPerson_type(String person_type) {
		this.person_type = person_type;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}	
	
	
}
