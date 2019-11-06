package com.benfante.javacourse.thelibrary.core.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class JpaAuthorDao implements AuthorDao {

	private EntityManagerFactory emf;

	public JpaAuthorDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		Author result = searchAuthorByFirstNameAndLastName(firstName, lastName);
		if (result == null) {
			EntityManager em = null;
			try  {
				em  = emf.createEntityManager();
				em.getTransaction().begin();
				result = new Author(null, firstName, lastName);
				em.persist(result);
				em.getTransaction().commit();
			} finally {
				if (em != null) em.close();
			}
		}
		return result;
	}

	@Override
	public Author searchAuthorByFirstNameAndLastName(String firstName, String lastName) {
		Author result = null;
		EntityManager em = null;
		try  {
			em  = emf.createEntityManager();
			TypedQuery<Author> query = em.createQuery(
					"SELECT a FROM Author a where a.firstName = :firstName AND a.lastName = :lastName", Author.class);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
			List<Author> authors = query.getResultList();
			if (!authors.isEmpty()) {
				result = authors.get(0);
			}
		} finally {
			if (em != null) em.close();
		}
		return result;
	}

}
