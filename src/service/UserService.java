package service;



import java.sql.Connection;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class UserService {

	public User authentication(String name, String pass) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			User user = userDao.findByIdAndPass(name, pass);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public int register(String name, String pass) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.register(name, pass);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
