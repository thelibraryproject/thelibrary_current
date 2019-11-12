package com.benfante.javacourse.thelibrary.core.dao;

import java.util.Collection;

import com.benfante.javacourse.thelibrary.core.model.Author;

public interface AuthorDao {
	Author getOrCreateAuthor(String firstName, String lastName);
	Author searchAuthorByFirstNameAndLastName(String firstName, String lastName);
	Collection<Author> findAll();
	void save(Author author);
	Author findById(Long id);
}
