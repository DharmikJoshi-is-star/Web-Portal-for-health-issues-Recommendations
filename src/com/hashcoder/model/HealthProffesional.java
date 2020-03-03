package com.hashcoder.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HealthProffesional {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String gender;
	
	private String contact;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private List<Disease> specialistInDisease;
	
	private List<Answer> answers;
	
	private Integer count_answers; 
	
	private Float avg_rating;
	
	private Integer rating_count;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Disease> getSpecialistInDisease() {
		return specialistInDisease;
	}

	public void setSpecialistInDisease(List<Disease> specialistInDisease) {
		this.specialistInDisease = specialistInDisease;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Integer getCount_answers() {
		return count_answers;
	}

	public void setCount_answers(Integer count_answers) {
		this.count_answers = count_answers;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
