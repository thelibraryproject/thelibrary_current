package com.benfante.javacourse.thelibrary.core.dao;

public interface DaoFactory {
	BookDao getBookDao();
	AuthorDao getAuthorDao();
}
