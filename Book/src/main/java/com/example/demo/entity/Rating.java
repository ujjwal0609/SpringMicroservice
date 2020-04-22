package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_rating")
public class Rating {
	
	@Id
	private long id;
	private long bookId;
	private int stars;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", bookId=" + bookId + ", stars=" + stars + "]";
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(long id, long bookId, int stars) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.stars = stars;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}

}
