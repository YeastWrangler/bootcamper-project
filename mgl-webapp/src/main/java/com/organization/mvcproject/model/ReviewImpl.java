package com.organization.mvcproject.model;

import com.organization.mvcproject.api.model.Review;

public class ReviewImpl implements Review {
	
	/**
	 * TODO 1.0 java object member variable naming convention, 
	 * one member declared here is not object oriented refactor it
	 */
	private String body;
	private String author;
	private Integer rating;

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public Integer getRating() {
		return rating;
	}

	@Override
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}
}
