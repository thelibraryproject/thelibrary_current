package com.benfante.javacourse.thelibrary.core.dao;

import com.benfante.javacourse.thelibrary.core.dao.mysql.ConnectionSource;
import com.benfante.javacourse.thelibrary.core.dao.mysql.MySqlDaoFactory;

public class DaoFactoryCreator {
	public static DaoFactory getDaoFactory() {
		return new MySqlDaoFactory(new ConnectionSource("jdbc:mysql://localhost/thelibrary?serverTimezone=UTC", "root", "root"));
	}
}
