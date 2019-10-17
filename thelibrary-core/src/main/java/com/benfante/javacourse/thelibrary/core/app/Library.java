package com.benfante.javacourse.thelibrary.core.app;

import java.math.BigDecimal;
import java.util.Scanner;

import com.benfante.javacourse.thelibrary.core.model.Book;

public class Library {

	public static void main(String[] args) {
		Book b1 = new Book(1, "Harry Potter", "J.K. Rowling");
		printBook(b1);
		Book b2 = new Book(2, "Dieci Piccoli Indiani", "Agatha Christie", new BigDecimal("12.20"));
		printBook(b2);
		Book b3 = new Book(3, "Assassinio sull'Orient Express", "Agatha Christie", new BigDecimal("10.20"));
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
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.print("Title: ");
		String title = scan.nextLine();
		System.out.print("Author: ");
		String author = scan.nextLine();
		System.out.print("Price: ");
		BigDecimal price = scan.nextBigDecimal();
		scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		return new Book(id, title, author, price);
	}

	private static void printBook(Book book) {
		System.out.println(book);
	}

}
