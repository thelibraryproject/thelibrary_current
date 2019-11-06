package com.benfante.javacourse.thelibrary.core.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class JpaBookDao implements BookDao {
	private EntityManagerFactory emf;

	public JpaBookDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Collection<Book> getAllBooks() {
		Collection<Book> result = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
			result = query.getResultList();
		} finally {
			em.close();
		}
		return result;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Book book) {
		// TODO Auto-generated method stub

	}

}
