package service;

import java.sql.Connection;

import dao.CharacterDao;
import dao.LevelInfoDao;
import entity.LevelInfo;
import util.DbUtil;

public class LevelInfoService {

	public int setExp(int exp, int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.setExp(exp, userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//ExpをuserIdで検索
	public int getExp(int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			LevelInfoDao levelInfoDao = new LevelInfoDao(conn);
			return levelInfoDao.getExp(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//LevelInfoテーブルから全件取得
	public LevelInfo getAll(int level) {
		try (Connection conn = DbUtil.getConnection()) {
			LevelInfoDao levelInfoDao = new LevelInfoDao(conn);
			return levelInfoDao.getAll(level);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

