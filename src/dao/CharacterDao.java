package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Characters;

public class CharacterDao {
	private static final String SQL_UPDATE_EXP = "UPDATE characters SET c_exp=? WHERE user_id=? ";
	private static final String SQL_SELECT_EXP = "SELECT c_exp FROM characters WHERE user_id=? ";
	private static final String SQL_SELECT_CHARACTERS_ALL = "SELECT * FROM characters WHERE user_id=? ";
	private Connection connection;

	public CharacterDao(Connection connection) {
		this.connection = connection;
	}
	public CharacterDao() {
	}

	public int setExp(int exp, int userId) {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_EXP)) {
			stmt.setInt(1, exp);
			stmt.setInt(2, userId);
			return stmt.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int getExp(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_EXP)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("c_exp");
			} else {
				return 0;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Characters getAll(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_CHARACTERS_ALL)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Characters(rs.getInt("user_id"), rs.getInt("level"), rs.getInt("c_exp"), rs.getInt("c_hp"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

