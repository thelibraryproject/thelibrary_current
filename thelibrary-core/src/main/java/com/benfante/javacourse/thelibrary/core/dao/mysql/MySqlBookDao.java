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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksBtAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Book book) {
		// TODO Auto-generated method stub

	}

}
