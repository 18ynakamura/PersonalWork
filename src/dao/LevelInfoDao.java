package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.LevelInfo;

public class LevelInfoDao {
	private static final String SQL_LEVELINFO_SELECT_ALL = "SELECT * FROM level_info WHERE level=? ";
	private Connection connection;

	public LevelInfoDao(Connection connection) {
		this.connection = connection;
	}


	public LevelInfo getAll(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_LEVELINFO_SELECT_ALL)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new LevelInfo(rs.getInt("level"), rs.getInt("exp"), rs.getInt("hp"), rs.getInt("attack"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

