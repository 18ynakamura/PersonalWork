package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.TaskDao;
import entity.Task;
import util.DbUtil;

public class TaskService {

	public int taskRegister(int id, String text) {
		try (Connection conn = DbUtil.getConnection()) {
			TaskDao taskDao = new TaskDao(conn);
			return taskDao.taskRegister(id, text);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Task>  selectUnfinishedTask(int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			TaskDao taskDao = new TaskDao(conn);
			return taskDao.selectUnfinishedTask(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}

