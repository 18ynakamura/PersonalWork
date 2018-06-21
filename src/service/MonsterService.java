package service;

import java.sql.Connection;

import dao.MonsterDao;
import entity.Monster;
import util.DbUtil;

public class MonsterService {


	//Monsterテーブルから全件取得
	public Monster getAll(int monster_id) {
		try (Connection conn = DbUtil.getConnection()) {
			MonsterDao monsterDao = new MonsterDao(conn);
			return monsterDao.getAll(monster_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

