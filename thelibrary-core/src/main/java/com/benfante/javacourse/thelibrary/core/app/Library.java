package com.benfante.javacourse.thelibrary.core.app;

import java.math.BigDecimal;

import com.benfante.javacourse.thelibrary.core.model.Book;

public class Library {

	public static void main(String[] args) {
		Book b1 = new Book(1, "Harry Potter", "J.K. Rowling");
		printBook(b1);
		Book b2 = new Book(2, "Dieci Piccoli Indiani", "Agatha Christie", new BigDecimal("12.20"));
		printBook(b2);
		Book b3 = new Book(3, "Assassinio sull'Orient Express", "Agatha Christie", new BigDecimal("10.20"));
		printBook(b3);
	}

	private static void printBook(Book book) {
		System.out.println(book);
	}

}
