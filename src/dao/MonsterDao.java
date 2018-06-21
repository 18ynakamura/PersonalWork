package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Monster;

public class MonsterDao {

	private static final String SQL_SELECT_MONSTERS_ALL = "SELECT * FROM monsters WHERE monster_id=? ";
	private Connection connection;

	public MonsterDao(Connection connection) {
		this.connection = connection;
	}
	public MonsterDao() {
	}


	public Monster getAll(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_MONSTERS_ALL)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Monster(rs.getInt("monster_id"), rs.getString("monster_name"), rs.getInt("monster_level"), rs.getInt("monster_hp"), rs.getInt("monster_attack"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

