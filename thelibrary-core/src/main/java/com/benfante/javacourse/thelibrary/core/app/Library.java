package com.benfante.javacourse.thelibrary.core.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

public class Library {

	private static final Logger log = LoggerFactory.getLogger(Library.class);

	private static final String SKIPPED_CHARS = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	Collection<Book> books = new HashSet<>();

	public void addBook(final Book book) {
		if (book != null) {
			log.info("Adding a book with id {} and title {}", book.getId(), book.getTitle());
			this.books.add(book);
		} else {
			log.warn("Passed null adding a book. Nothing was really added.");
		}
	}

	
	public void removeBook(Book book) {
		log.info("Trying to remove the book with id {} ({})", book.getId(), book.getTitle());
		if (this.books.contains(book)) {
			this.books.remove(book);
			log.info("Removed the book with id {} ({})", book.getId(), book.getTitle());
		} else {
			log.warn("Book with id {} ({}) not found", book.getId(), book.getTitle());
		}
	}

	public void printBooks() {
//		System.out.println(Arrays.toString(this.books));
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public Book[] searchBooksByTitle(String partialTitle) {
		log.debug("Searching books with title containing \"{}\"", partialTitle);
		List<Book> result = new ArrayList<>();
		for (Book book : this.books) {
			if (book.getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
				result.add(book);
			}
		}
		log.debug("Found {} books", result.size());
		return result.toArray(new Book[result.size()]);
	}

	public Book[] searchBooksByAuthor(Author author) {
		log.debug("Searching books written by an author with id {}", author.getId());
		List<Book> result = new ArrayList<>();
		for (Book book : this.books) {
			if (book.isWrittenBy(author)) {
				result.add(book);
			}
		}
		log.debug("Found {} books", result.size());
		return result.toArray(new Book[result.size()]);
	}

	public void readBooks(InputStream is) throws IOException {
		Reader isr = new InputStreamReader(is);
		BufferedReader r = new BufferedReader(isr);
		String line = null;
		while((line = r.readLine()) != null) {
			String[] bookFields = line.split(",");
			long id = Long.valueOf(bookFields[0]);
			String title = bookFields[1];
			Book book = new Book(id, title, (Author)null);
			if (!bookFields[2].isBlank()) {
				log.trace(bookFields[2]);
				String[] authors = bookFields[2].split("\\|");
				for (String author : authors) {
					log.trace(author);
					String[] authorFields = author.split(";");
					book.addAuthor(new Author(Long.valueOf(authorFields[0]), authorFields[1], authorFields[2]));
				}
			}
			if (!bookFields[3].isBlank()) {
				String[] publisherFields = bookFields[3].split(";");
				book.setPublisher(new Publisher(Long.valueOf(publisherFields[0]), publisherFields[1]));
			}
			if (!bookFields[4].isBlank()) {
				book.setPrice(new BigDecimal(bookFields[4]));
			}
			this.addBook(book);
		}
	}
	

	public void writeBooks(OutputStream os) {
		PrintWriter out = new PrintWriter(os);
		for (Book book : this.books) {
			out.print(book.getId());
			out.print(',');
			out.print(book.getTitle());
			out.print(',');
			for (int i = 0; i < book.getAuthors().length; i++) {
				Author author = book.getAuthors()[i];
				out.print(author.getId());
				out.print(';');
				out.print(author.getFirstName());
				out.print(';');
				out.print(author.getLastName());
				if (i != book.getAuthors().length -1) {
					out.print('|');
				}
			}
			out.print(',');
			Publisher publisher = book.getPublisher();
			if (publisher != null) {
				out.print(publisher.getId());
				out.print(';');
				out.print(publisher.getName());
			}
			out.print(',');
			out.print(book.getPrice());
			out.println();
		}
		out.flush();
	}
	
	public static void main(String[] args) throws IOException {
		Library library = new Library();
		
//		readingFromCsvFile(library);
		
		usingDaos();
	}


	private static void readingFromCsvFile(Library library) throws IOException, FileNotFoundException {
		String userHome = System.getProperty("user.home");
		String filename = "library.csv";
		File file = new File(userHome, filename);
		if (file.exists()) {
			log.info("Reading books from {}", file.getAbsolutePath());
			try (InputStream fis = new FileInputStream(file);
					InputStream is = new BufferedInputStream(fis);) {
				library.readBooks(is);
			}
		} else {
			log.warn("The file {} doesn't exist", file.getAbsolutePath());
		}
		
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
		System.out.println("*********************************************");
		System.out.println("** Printing all the archive...");
		System.out.println("*********************************************");
		library.printBooks();
		System.out.println("*********************************************");
		System.out.println("** Searching all Agatha Christie Books...");
		System.out.println("*********************************************");
		Book[] christieBooks = library.searchBooksByAuthor(new Author(1, "Agatha", "Christie"));
		System.out.println(Arrays.toString(christieBooks));

		log.info("Storing the book archive into the file {}", file.getAbsolutePath());
		try (OutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
			library.writeBooks(os);
		}
	}

	
	private static void usingDaos() {
		DaoFactory daoFactory = DaoFactoryCreator.getDaoFactory();
		AuthorDao authorDao = daoFactory.getAuthorDao();
		Author author = authorDao.searchAuthorByFirstNameAndLastName("Agatha", "Christie");
		System.out.println(author);
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

	@SuppressWarnings("unused")
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
