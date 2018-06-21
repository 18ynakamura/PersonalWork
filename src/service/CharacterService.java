package service;

import java.sql.Connection;

import dao.CharacterDao;
import entity.Characters;
import util.DbUtil;

public class CharacterService {

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
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.getExp(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//Characterテーブルから全件取得
	public Characters getAll(int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.getAll(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

