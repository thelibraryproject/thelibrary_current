package com.benfante.javacourse.thelibrary.core.app;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

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
		int previousSize = library.books.size();
		library.addBook(new Book(0, "A book for testing", new Author[0]));
		assertEquals(previousSize + 1, library.books.size());
	}

	@Test
	public void testRemoveBook() {
		Book book = new Book(0, "A book for testing", new Author[0]);
		library.addBook(book);
		int previousSize = library.books.size();
		library.removeBook(book);
		assertEquals(previousSize - 1, library.books.size());
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

	
	@Test
	public void testReadBooks() throws IOException {
		Library app = new Library();
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("library.csv");
		
		app.readBooks(is);
		
		Book[] booksAsArray = app.books.toArray(new Book[app.books.size()]);
		
		assertEquals(5, booksAsArray.length);
		assertEquals(1, booksAsArray[0].getId());
		assertEquals("Harry Potter", booksAsArray[0].getTitle());
		assertEquals(1, booksAsArray[0].getAuthors().length);
		assertEquals(2, booksAsArray[4].getAuthors().length);
		assertNull(booksAsArray[0].getPublisher());
		assertNotNull(booksAsArray[4].getPublisher());
		assertEquals(new BigDecimal("0.0"), booksAsArray[0].getPrice());
		assertEquals(new BigDecimal("44.71"), booksAsArray[4].getPrice());
	}
	
	@Test
	public void testWriteGof() throws IOException {
		Book book = new Book(5, "Design Patterns",
				new Author[] {
						new Author(3, "Erich", "Gamma"),
						new Author(4, "Richard", "Helm")
				},
				new Publisher(1, "Addison-Wesley Professional"),
				new BigDecimal("44.71"));
		
		Library app = new Library();
		app.addBook(book);
		
		String result = null;
		try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			app.writeBooks(os);
			result = os.toString();
		}
		
		String expected = "5,Design Patterns,3;Erich;Gamma|4;Richard;Helm,1;Addison-Wesley Professional,44.71"
				+System.getProperty("line.separator");

		assertEquals(expected, result);
	}
	
}
