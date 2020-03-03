package com.hashcoder.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Query {

	private Integer id;
	
	private Integer user_id;
	
	private String query;
	
	private Date date;
	
	private Time time;
	
	private List<Answer> answers;
	
	private List<Disease> disease;

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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Disease> getDisease() {
		return disease;
	}

	public void setDisease(List<Disease> disease) {
		this.disease = disease;
	}
	
	
}
