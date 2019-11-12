package com.benfante.javacourse.thelibrary.core.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.DataSource;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class MySqlAuthorDao implements AuthorDao {
	private DataSource dataSource;

	public MySqlAuthorDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		Author result = searchAuthorByFirstNameAndLastName(firstName, lastName);
		if (result == null) {
			try (Connection conn = this.dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement(
							"INSERT INTO author (first_name, last_name) VALUES (?, ?)",
							Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.executeUpdate();
				long id = 0;
				try (ResultSet keysRs = stmt.getGeneratedKeys()) {
					if (keysRs.next()) {
						id = keysRs.getLong(1);
					}
				}
				result = new Author(id, firstName, lastName);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	/**
	 * 
	 * @throws RuntimeException in case of error
	 */
	@Override
	public Author searchAuthorByFirstNameAndLastName(String firstName, String lastName) throws RuntimeException {
		Author result = null;
		try (Connection conn = this.dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT id, first_name, last_name FROM author where first_name = ? AND last_name = ?")) {
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					result = new Author(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Collection<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
