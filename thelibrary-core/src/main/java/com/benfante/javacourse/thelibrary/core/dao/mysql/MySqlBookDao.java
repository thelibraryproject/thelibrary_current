package com.benfante.javacourse.thelibrary.core.dao.mysql;

import java.util.Collection;

import javax.sql.DataSource;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class MySqlBookDao implements BookDao {

	public MySqlBookDao(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Book> getAllBooks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Book[] searchBooksByTitle(String title) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Book[] searchBooksBtAuthor(Author author) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void store(Book book) {
		throw new UnsupportedOperationException();
	}

}
