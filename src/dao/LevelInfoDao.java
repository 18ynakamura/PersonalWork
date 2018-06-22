package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.LevelInfo;

public class LevelInfoDao {
	private static final String SQL_LEVELINFO_SELECT_ALL = "SELECT * FROM level_info WHERE level=? ";
	private static final String SQL_LEVELINFO_SELECT_EXP = "SELECT exp FROM level_info WHERE level=? ";
	private Connection connection;

	public LevelInfoDao(Connection connection) {
		this.connection = connection;
	}


	public LevelInfo getAll(int level) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_LEVELINFO_SELECT_ALL)) {
			stmt.setInt(1, level);
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
	public int getExp(int level) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_LEVELINFO_SELECT_EXP)) {
			stmt.setInt(1, level);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("exp");
			} else {
				return 0;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

