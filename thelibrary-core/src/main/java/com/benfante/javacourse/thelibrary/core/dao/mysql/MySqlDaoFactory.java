package com.benfante.javacourse.thelibrary.core.dao.mysql;

import javax.sql.DataSource;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;

public class MySqlDaoFactory implements DaoFactory {
	private DataSource dataSource;
	
	public MySqlDaoFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public BookDao getBookDao() {
		return new MySqlBookDao(dataSource);
	}

	@Override
	public AuthorDao getAuthorDao() {
		return new MySqlAuthorDao(dataSource);
	}

}
