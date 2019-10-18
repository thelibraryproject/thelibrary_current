package com.benfante.javacourse.thelibrary.core.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class LibraryTest {

	@Test
	public void testAddBook() {
		Library library = new Library();
		int previousSize = library.books.length;
		library.addBook(new Book(0, "A book for testing", new Author[0]));
		assertEquals(previousSize+1, library.books.length);
	}

	@Test
	public void testRemoveBook() {
		Library library = new Library();
		Book book = new Book(0, "A book for testing", new Author[0]);
		library.addBook(book);
		int previousSize = library.books.length;
		library.removeBook(book);
		assertEquals(previousSize-1, library.books.length);
	}

}
