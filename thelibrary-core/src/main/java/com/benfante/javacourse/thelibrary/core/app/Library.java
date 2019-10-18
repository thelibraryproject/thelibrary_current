package com.benfante.javacourse.thelibrary.core.app;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

public class Library {

	private static final String SKIPPED_CHARS = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	Book[] books = new Book[0];

	public void addBook(Book book) {
		if (book != null) {
			this.books = Arrays.copyOf(this.books, this.books.length + 1);
			this.books[this.books.length - 1] = book;
		} else {
			System.out.println("WARNING: passed null adding a book. Nothing was really added.");
		}
	}

	public void removeBook(Book book) {
		int found = -1;
		for(int i = 0; i < this.books.length; i++) {
			if (this.books[i].getId() == book.getId()) {
				found = i;
				break;
			}
		}
		if (found != -1) {
			Book[] shortedBooks = new Book[this.books.length - 1];
			System.arraycopy(this.books, 0, shortedBooks, 0, found);
			System.arraycopy(this.books, found + 1, shortedBooks, found, shortedBooks.length - found);
			this.books = shortedBooks;
		}
	}

	public void printBooks() {
//		System.out.println(Arrays.toString(this.books));
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	public static void main(String[] args) {
		Library library = new Library();
		
		Author rowling = new Author(0, "J.K.", "Rowling");
		Book b1 = new Book(1, "Harry Potter", rowling);
		library.addBook(b1);
		Author christie = new Author(1, "Agatha", "Christie");
		Book b2 = new Book(2, "Dieci Piccoli Indiani", christie, new BigDecimal("12.20"));
		library.addBook(b2);
		Book b3 = new Book(3, "Assassinio sull'Orient Express", christie, new BigDecimal("10.20"));
		library.addBook(b3);

		Scanner scan = new Scanner(System.in);

		String again = "";
		while (!"y".equals(again) && !"n".equals(again)) {
			System.out.print("Another book? (y/n) ");
			again = scan.nextLine();
		}
		while ("y".equals(again)) {
			Book b5 = readBook(scan);
			library.addBook(b5);
			do {
				System.out.print("Again? (y/n) ");
				again = scan.nextLine();
			} while (!"y".equals(again) && !"n".equals(again));
		}
		System.out.println("Bye bye!");
		library.printBooks();
	}

	private static Book readBook(Scanner scan) {
		System.out.print("Id: ");
		long id = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		System.out.print("Title: ");
		String title = scan.nextLine();
		Book result = new Book(id, title, new Author[0]);
		int authorCount = 0;
		String anotherAuthor = null;
		do {
			authorCount++;
			System.out.printf("Author %d: \n", authorCount);
			System.out.print("\tId: ");
			long authorId = scan.nextLong();
			scan.skip(SKIPPED_CHARS);
			System.out.print("\tFirst name: ");
			String firstName = scan.nextLine();
			System.out.print("\tLast name: ");
			String lastName = scan.nextLine();
			Author author = new Author(authorId, firstName, lastName);
			result.addAuthor(author);
			System.out.print("Another author? (y/n) ");
			anotherAuthor = scan.nextLine();
		} while ("y".equals(anotherAuthor));
		System.out.println("Publisher: ");
		System.out.print("\tId (or -1 for no publisher): ");
		long publisherId = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		Publisher publisher = null;
		if (publisherId != -1) {
			System.out.print("\tName: ");
			String name = scan.nextLine();
			publisher = new Publisher(publisherId, name);
		}
		result.setPublisher(publisher);
		System.out.print("Price: ");
		BigDecimal price = scan.nextBigDecimal();
		scan.skip(SKIPPED_CHARS);
		result.setPrice(price);
		return result;
	}

	private static void printBook(Book book) {
		System.out.println(book);
	}

}
