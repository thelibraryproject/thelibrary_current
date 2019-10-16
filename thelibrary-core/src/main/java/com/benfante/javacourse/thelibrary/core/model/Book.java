package com.benfante.javacourse.thelibrary.core.model;

import java.math.BigDecimal;

public class Book {
	private long id;
	private String title;
	private String author;
	private BigDecimal price;
	
	public Book(long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Book(long id, String title, String author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override	
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	

}