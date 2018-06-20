package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class TaskDao {
	private static final String SQL_INSERT = "INSERT INTO tasks (user_id, text, status) VALUES(?, ?, 'unfinished')";
	private static final String SQL_SELECT_TASK_UNFINISHED = "SELECT * FROM tasks WHERE user_id=? AND status='unfinished'";
	private Connection connection;

	public TaskDao(Connection connection) {
		this.connection = connection;
	}

	public TaskDao() {
	}

	public int taskRegister(int id, String text) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setInt(1, id);
			stmt.setString(2, text);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Task> selectUnfinishedTask(int userId) {
		List<Task> list = new ArrayList<Task>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_TASK_UNFINISHED)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Task t = new Task(rs.getInt("task_id"), rs.getInt("user_id"), rs.getString("text"), rs.getString("status"));
				list.add(t);
			}else {
				return null;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} return list;
	}
}
