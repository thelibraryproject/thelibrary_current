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
		for (int i = 0; i < this.books.length; i++) {
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

	public Book[] searchBooksByTitle(String partialTitle) {
		Book[] result = new Book[0];
		for (Book book : this.books) {
			if (book.getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = book;
			}
		}
		return result;
	}

	public Book[] searchBooksByAuthor(Author author) {
		Book[] result = new Book[0];
		for (Book book : this.books) {
			if (book.isWrittenBy(author)) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = book;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Library library = new Library();

		Scanner scan = new Scanner(System.in);

		String again = "";
		while (!"y".equals(again) && !"n".equals(again)) {
//			System.out.print("Another book? (y/n) ");
			again = scan.nextLine();
		}
		while ("y".equals(again)) {
			Book b5 = readBookWithoutMessages(scan);
			library.addBook(b5);
			do {
//				System.out.print("Again? (y/n) ");
				again = scan.nextLine();
			} while (!"y".equals(again) && !"n".equals(again));
		}
//		System.out.println("Bye bye!");
		System.out.println("*********************************************");
		System.out.println("** Printing all the archive...");
		System.out.println("*********************************************");
		library.printBooks();
		System.out.println("*********************************************");
		System.out.println("** Searching all Agatha Christie Books...");
		System.out.println("*********************************************");
		Book[] christieBooks = library.searchBooksByAuthor(new Author(1, "Agatha", "Christie"));
		System.out.println(Arrays.toString(christieBooks));
	}

	@SuppressWarnings("unused")
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

	private static Book readBookWithoutMessages(Scanner scan) {
		long id = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		String title = scan.nextLine();
		Book result = new Book(id, title, new Author[0]);
		String anotherAuthor = null;
		do {
			long authorId = scan.nextLong();
			scan.skip(SKIPPED_CHARS);
			String firstName = scan.nextLine();
			String lastName = scan.nextLine();
			Author author = new Author(authorId, firstName, lastName);
			result.addAuthor(author);
			anotherAuthor = scan.nextLine();
		} while ("y".equals(anotherAuthor));
		long publisherId = scan.nextLong();
		scan.skip(SKIPPED_CHARS);
		Publisher publisher = null;
		if (publisherId != -1) {
			String name = scan.nextLine();
			publisher = new Publisher(publisherId, name);
		}
		result.setPublisher(publisher);
		BigDecimal price = scan.nextBigDecimal();
		scan.skip(SKIPPED_CHARS);
		result.setPrice(price);
		return result;
	}

	@SuppressWarnings("unused")
	private static void printBook(Book book) {
		System.out.println(book);
	}

}
