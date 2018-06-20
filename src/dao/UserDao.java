package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT user_id, name, password FROM users WHERE name = ? AND password = ?";

	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}
	public UserDao() {
	}

	public User findByIdAndPass(String name, String pass) {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
			stmt.setString(1, name);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("password"));
			}else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
