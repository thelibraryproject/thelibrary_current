package com.benfante.javacourse.thelibrary.core.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Book implements Comparable<Book> {
	private static final Logger log = LoggerFactory.getLogger(Book.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@ManyToMany
	@JoinTable(name = "book_author",
		joinColumns = @JoinColumn(name="book_id"),
		inverseJoinColumns = @JoinColumn(name="author_id"))
	private List<Author> authors;
	private BigDecimal price;
	@ManyToOne
	private Publisher publisher;

	public Book() {
	}

	public Book(Long id, String title, Author author) {
		this(id, title, author, null, null);
	}

	public Book(Long id, String title, Author author, BigDecimal price) {
		this(id, title, author, null, price);
	}

	public Book(Long id, String title, Author author, Publisher publisher, BigDecimal price) {
		this(id, title, author != null ? new Author[] { author } : null, publisher, price);
	}

	public Book(Long id, String title, Author[] authors, Publisher publisher, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.authors = new ArrayList<>();
		if (authors != null) {
			Collections.addAll(this.authors, authors);
		}
		this.publisher = publisher;
		this.price = price;
	}

	public Book(Long id, String title, Author[] authors, BigDecimal price) {
		this(id, title, authors, null, price);
	}

	public Book(Long id, String title, Author[] authors) {
		this(id, title, authors, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author[] getAuthors() {
		return authors.toArray(new Author[0]);
	}

	public void setAuthors(Author[] authors) {
		this.authors.clear();
		Collections.addAll(this.authors, authors);
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
		publisher.getBooks().add(this);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void addAuthor(Author author) {
		log.info("Adding author ({}, {}, {}) to the book with id {} ({})", author.getId(), author.getFirstName(),
				author.getLastName(), this.id, this.title);
		this.authors.add(author);
	}

	public boolean isWrittenBy(Author author) {
		int otherHashCode = author.hashCode();
		for (Author current : this.authors) {
			if (current.hashCode() == otherHashCode && current.equals(author)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", price=" + price + ", publisher="
				+ publisher + "]";
	}

	@Override
	public int compareTo(Book o) {
//		return Long.valueOf(this.id).compareTo(o.id);
		return (int) (this.id - o.id);
	}

}