package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManagerFactory;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;

public class JpaDaoFactory implements DaoFactory {
	private EntityManagerFactory emf;
	
	public JpaDaoFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public BookDao getBookDao() {
		return new JpaBookDao(emf);
	}

	@Override
	public AuthorDao getAuthorDao() {
		return new JpaAuthorDao(emf);
	}

}
