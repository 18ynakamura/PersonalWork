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
	private static final String SQL_SELECT_TASK_FINISHED = "SELECT * FROM tasks WHERE user_id=? AND status='finished'";
	private static final String SQL_UPDATE_TASK_STATUS = "UPDATE tasks SET status='finished' WHERE task_id=?";
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
	//tasksテーブルのuser_idが一致するレコードをTask entityに保存、TaskEntityのリスト作成
	public List<Task> selectUnfinishedTask(int userId) {
		List<Task> list = new ArrayList<Task>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_TASK_UNFINISHED)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task t = new Task(rs.getInt("task_id"), rs.getInt("user_id"), rs.getString("text"), rs.getString("status"));
				list.add(t);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}return list;
	}
	//finishedのタスクをセレクト、リスト化
	public List<Task> selectFinishedTask(int userId) {
		List<Task> list = new ArrayList<Task>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_TASK_FINISHED)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task t = new Task(rs.getInt("task_id"), rs.getInt("user_id"), rs.getString("text"), rs.getString("status"));
				list.add(t);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}return list;
	}
	//taskIdをcheckboxで取得、statusをunfinishedからfinishedに変更
	public int taskStatusUpdate(int taskId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_TASK_STATUS)) {
			stmt.setInt(1, taskId);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
