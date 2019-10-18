package com.benfante.javacourse.thelibrary.core.app;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class LibraryTest {
	private Library library;

	@Before
	public void setupTests() {
		library = new Library();

		Author rowling = new Author(0, "J.K.", "Rowling");
		Book b1 = new Book(1, "Harry Potter", rowling);
		library.addBook(b1);
		Author christie = new Author(1, "Agatha", "Christie");
		Book b2 = new Book(2, "Dieci Piccoli Indiani", christie, new BigDecimal("12.20"));
		library.addBook(b2);
		Book b3 = new Book(3, "Assassinio sull'Orient Express", christie, new BigDecimal("10.20"));
		library.addBook(b3);
	}

	@Test
	public void testAddBook() {
		int previousSize = library.books.length;
		library.addBook(new Book(0, "A book for testing", new Author[0]));
		assertEquals(previousSize + 1, library.books.length);
	}

	@Test
	public void testRemoveBook() {
		Book book = new Book(0, "A book for testing", new Author[0]);
		library.addBook(book);
		int previousSize = library.books.length;
		library.removeBook(book);
		assertEquals(previousSize - 1, library.books.length);
	}

	@Test
	public void testSearchBooksByTitle() {
		Book[] result = library.searchBooksByTitle("Dieci");
		assertEquals(1, result.length);
		assertTrue(result[0].getTitle().contains("Dieci"));
	}

	@Test
	public void testSearchBooksByAuthor() {
		Book[] result = library.searchBooksByAuthor(new Author(1, "not", "important"));
		assertEquals(2, result.length);
	}

}
