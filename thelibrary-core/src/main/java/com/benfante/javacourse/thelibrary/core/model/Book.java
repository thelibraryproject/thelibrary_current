package com.benfante.javacourse.thelibrary.core.model;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	
	private long id;
	private String title;
	private Author[] authors;
	private BigDecimal price;
	private Publisher publisher;

	public Book(long id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.authors = new Author[] { author };
	}

	public Book(long id, String title, Author author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.authors = new Author[] { author };
		this.price = price;
	}

	public Book(long id, String title, Author author, Publisher publisher, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.authors = new Author[] { author };
		this.publisher = publisher;
		this.price = price;
	}

	public Book(long id, String title, Author[] authors, Publisher publisher, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.authors = authors != null ? authors : new Author[0];
		this.publisher = publisher;
		this.price = price;
	}

	public Book(long id, String title, Author[] authors, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.authors = authors != null ? authors : new Author[0];
		this.price = price;
	}

	public Book(long id, String title, Author[] authors) {
		this.id = id;
		this.title = title;
		this.authors = authors != null ? authors : new Author[0];
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

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
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

	public void addAuthor(Author author) {
		log.info("Adding author ({}, {}, {}) to the book with id {} ({})", author.getId(), author.getFirstName(), author.getLastName(), this.id, this.title);
		Author[] largerAuthors = Arrays.copyOf(this.authors, this.authors.length + 1); // or using a for loop ;)
		largerAuthors[largerAuthors.length - 1] = author;
		this.authors = largerAuthors;
	}

	// just for showing the verbose method
	public void addAuthorWithoutArrays(Author author) {
		Author[] largerAuthors = new Author[this.authors.length + 1];
		for(int i = 0; i < this.authors.length; i++) {
			largerAuthors[i] = this.authors[i];
		}
		largerAuthors[largerAuthors.length - 1] = author;
		this.authors = largerAuthors;
	}
	
	public boolean isWrittenBy(Author author) {
		for (Author current : this.authors) {
			if (current.getId() == author.getId()) {
				return true;
			}
		}
		return false;
	}	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + Arrays.toString(authors) + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}

}