package service;

import java.sql.Connection;

import dao.CharacterDao;
import entity.CharLvJoin;
import entity.CharLvJoin2;
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

	public int setHp(int c_hp, int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.setHp(c_hp, userId);
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

	public CharLvJoin getHpAttack(int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.getHpAttack(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CharLvJoin2 getJoinHp(int userId) {
		try (Connection conn = DbUtil.getConnection()) {
			CharacterDao characterDao = new CharacterDao(conn);
			return characterDao.getJoinHp(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

