package entity;

public class Characters {
	private int user_id;
	private int level;
	private int c_exp;
	private int c_hp;

	public Characters(int user_id, int level, int c_exp, int c_hp) {
		this.user_id = user_id;
		this.level = level;
		this.c_exp = c_exp;
		this.c_hp = c_hp;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getC_exp() {
		return c_exp;
	}
	public void setC_exp(int c_exp) {
		this.c_exp = c_exp;
	}
	public int getC_hp() {
		return c_hp;
	}
	public void setC_hp(int c_hp) {
		this.c_hp = c_hp;
	}

}

