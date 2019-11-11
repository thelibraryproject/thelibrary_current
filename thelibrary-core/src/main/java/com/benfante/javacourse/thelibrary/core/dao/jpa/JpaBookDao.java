package com.benfante.javacourse.thelibrary.core.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.hibernate.graph.GraphSemantic;
import org.hibernate.jpa.QueryHints;

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
			EntityGraph<Book> graph = em.createEntityGraph(Book.class);
			graph.addAttributeNodes("authors");
			
			TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
			query.setHint(GraphSemantic.LOAD.getJpaHintName(), graph);
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
