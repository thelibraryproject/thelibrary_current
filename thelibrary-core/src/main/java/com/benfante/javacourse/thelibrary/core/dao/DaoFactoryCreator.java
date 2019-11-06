package com.benfante.javacourse.thelibrary.core.dao;

import javax.persistence.Persistence;

import org.apache.commons.dbcp2.BasicDataSource;

import com.benfante.javacourse.thelibrary.core.dao.jpa.JpaDaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.mysql.MySqlDaoFactory;

public class DaoFactoryCreator {
	public static DaoFactory getDaoFactory() {
		return createJpaDaoFactory();
	}

	private static DaoFactory createJpaDaoFactory() {
		return new JpaDaoFactory(Persistence.createEntityManagerFactory("thelibrary"));
	}

	private static DaoFactory createMySqlDaoFactory() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/thelibrary?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return new MySqlDaoFactory(dataSource);
	}
}
