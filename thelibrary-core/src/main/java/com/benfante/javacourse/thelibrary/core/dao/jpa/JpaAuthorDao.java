package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManagerFactory;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class JpaAuthorDao implements AuthorDao {

	private EntityManagerFactory emf;

	public JpaAuthorDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author searchAuthorByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
