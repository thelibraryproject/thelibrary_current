package com.benfante.javacourse.thelibrary.core.dao;

import java.util.Collection;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public interface BookDao {
	Collection<Book> getAllBooks();
	Book searchBookByIsbn(String isbn);
	Book[] searchBooksByTitle(String title);
	Book[] searchBooksByAuthor(Author author);
	void store(Book book);
}
