package com.hashcoder.model;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Disease {

	
	private Integer id;
	
	@Size(min = 2, max = 30, message = "disease name should be between 4-30 chars")
	private String name;
	
	@Size(min = 2, max = 30, message = "category name should be between 4-30 chars")
	private String category;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
