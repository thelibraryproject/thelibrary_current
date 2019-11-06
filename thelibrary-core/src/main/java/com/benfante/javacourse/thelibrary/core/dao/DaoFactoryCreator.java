package com.benfante.javacourse.thelibrary.core.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import com.benfante.javacourse.thelibrary.core.dao.mysql.MySqlDaoFactory;

public class DaoFactoryCreator {
	public static DaoFactory getDaoFactory() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/thelibrary?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return new MySqlDaoFactory(dataSource);
	}
}
