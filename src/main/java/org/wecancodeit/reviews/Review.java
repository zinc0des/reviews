package org.wecancodeit.reviews;

import java.time.Instant;
import java.util.Date;

public class Review {
	private long id;
	private String title;
	private String description;
	private String imageUrl;
	private String category;
	private Date dateOfReview;
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImage(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateOfReview() {
		return dateOfReview;
	}

	public void setDate(Date dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Review(
			long id,
			String title,
			String description,
			String category,
			String content,
			String imageURL) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageUrl = imageURL;
		this.category = category; 
		this.dateOfReview = new Date();//Date.from(Instant.now());
		this.content = content;
	}

	}