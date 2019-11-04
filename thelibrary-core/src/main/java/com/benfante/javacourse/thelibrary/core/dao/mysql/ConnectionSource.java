package com.benfante.javacourse.thelibrary.core.dao.mysql;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ConnectionSource implements DataSource {
	private String connectionUrl;
	private String username;
	private String password;
	
	public ConnectionSource(String connectionUrl, String username, String password) {
		this.connectionUrl = connectionUrl;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(connectionUrl, username, password);
	}


	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return DriverManager.getConnection(connectionUrl, username, password);
	}


	@Override
	public PrintWriter getLogWriter() throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}


	@Override
	public int getLoginTimeout() throws SQLException {
        throw new SQLFeatureNotSupportedException("not implemented");
	}
}
