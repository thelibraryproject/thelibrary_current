package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBookLongStringAuthor() {
		Book book = new Book(0L, "A book", new Author(1L, "A test", "Author"));
		assertEquals(1, book.getAuthors().length);
	}

	@Test
	public void testAddAuthor() {
		Book book = new Book(0L, "A book", new Author(1L, "A test", "Author"));
		int previousSize = book.getAuthors().length;
		book.addAuthor(new Author(10L, "Another", "Author"));
		assertEquals(previousSize+1, book.getAuthors().length);
		assertEquals(Long.valueOf(10L), book.getAuthors()[book.getAuthors().length-1].getId());
	}

}
