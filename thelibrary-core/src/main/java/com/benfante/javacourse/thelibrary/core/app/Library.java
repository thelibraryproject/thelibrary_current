package com.benfante.javacourse.thelibrary.core.app;

import java.math.BigDecimal;
import java.util.Scanner;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

public class Library {

	private static final String SKIPPED_CHARS = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	public static void main(String[] args) {
		Author rowling = new Author(0, "J.K.", "Rowling");
		Book b1 = new Book(1, "Harry Potter", rowling);
		printBook(b1);
		Author christie = new Author(1, "Agatha", "Christie");
		Book b2 = new Book(2, "Dieci Piccoli Indiani", christie, new BigDecimal("12.20"));
		printBook(b2);
		Book b3 = new Book(3, "Assassinio sull'Orient Express", christie, new BigDecimal("10.20"));
		printBook(b3);

		Scanner scan = new Scanner(System.in);

		String again = "";
		while (!"y".equals(again) && !"n".equals(again)) {
			System.out.print("Another book? (y/n) ");
			again = scan.nextLine();
		}
		while ("y".equals(again)) {
			Book b5 = readBook(scan);
			System.out.println(b5);
			do {
				System.out.print("Again? (y/n) ");
				again = scan.nextLine();
			} while (!"y".equals(again) && !"n".equals(again));
		}
		System.out.println("Bye bye!");
	}

	private static Book readBook(Scanner scan) {
		System.out.print("Id: ");
		long id = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		System.out.print("Title: ");
		String title = scan.nextLine();
		System.out.println("Author: ");
		System.out.print("\tId: ");
		long authorId = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		System.out.print("\tFirst name: ");
		String firstName = scan.nextLine();
		System.out.print("\tLast name: ");
		String lastName = scan.nextLine();
		Author author = new Author(authorId, firstName, lastName);
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
		System.out.print("Price: ");
		BigDecimal price = scan.nextBigDecimal();
		scan.skip(SKIPPED_CHARS);
		return new Book(id, title, author, publisher, price);
	}

	private static void printBook(Book book) {
		System.out.println(book);
	}

}
