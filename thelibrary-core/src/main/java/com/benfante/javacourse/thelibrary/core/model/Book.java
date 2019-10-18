package com.benfante.javacourse.thelibrary.core.model;

import java.math.BigDecimal;

public class Book {
	private long id;
	private String title;
	private Author author;
	private BigDecimal price;
	private Publisher publisher;

	public Book(long id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Book(long id, String title, Author author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(long id, String title, Author author, Publisher publisher, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", publisher="
				+ publisher + "]";
	}

}