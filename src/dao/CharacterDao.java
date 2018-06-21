package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CharLvJoin;
import entity.CharLvJoin2;
import entity.CharLvJoin3;
import entity.Characters;

public class CharacterDao {
	private static final String SQL_UPDATE_EXP = "UPDATE characters SET c_exp=? WHERE user_id=? ";
	private static final String SQL_UPDATE_HP = "UPDATE characters SET c_hp=? WHERE user_id=? ";
	private static final String SQL_SELECT_EXP = "SELECT c_exp FROM characters WHERE user_id=? ";
	private static final String SQL_SELECT_CHARACTERS_ALL = "SELECT * FROM characters WHERE user_id=? ";
	private static final String SQL_JOIN_CHARACTERS_LEVELINFO = "SELECT c.c_hp, l.attack FROM characters c JOIN level_info l ON c.level = l.level WHERE c.user_id = ?";
	private static final String SQL_JOIN_CHARACTERS_LEVELINFO_SELECT_HP = "SELECT c.c_hp, l.hp FROM characters c JOIN level_info l ON c.level = l.level WHERE c.user_id = ?";
	private static final String SQL_JOIN_CHARACTERS_LEVELINFO_SELECT_EXP = "SELECT c.c_exp, l.exp FROM characters c JOIN level_info l ON c.level = l.level WHERE c.user_id = ?";
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

	public int setHp(int c_hp, int userId) {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_HP)) {
			stmt.setInt(1, c_hp);
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

	public CharLvJoin getHpAttack(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_JOIN_CHARACTERS_LEVELINFO)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new CharLvJoin(rs.getInt("c_hp"), rs.getInt("attack"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public CharLvJoin2 getJoinHp(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_JOIN_CHARACTERS_LEVELINFO_SELECT_HP)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new CharLvJoin2(rs.getInt("c_hp"), rs.getInt("hp"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public CharLvJoin3 getJoinExp(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_JOIN_CHARACTERS_LEVELINFO_SELECT_EXP)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new CharLvJoin3(rs.getInt("c_exp"), rs.getInt("exp"));
			} else {
				return null;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

