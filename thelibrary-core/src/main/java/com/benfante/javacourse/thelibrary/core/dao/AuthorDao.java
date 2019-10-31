package com.benfante.javacourse.thelibrary.core.dao;

import com.benfante.javacourse.thelibrary.core.model.Author;

public interface AuthorDao {
	Author getOrCreateAuthor(String firstName, String lastName);
	Author searchAuthorByFirstNameAndLastName(String firstName, String lastName);
}
