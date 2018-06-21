package entity;

public class LevelInfo {
	private int level;
	private int exp;
	private int hp;
	private int attack;
	public LevelInfo(int level, int exp, int hp, int attack) {
		this.level = level;
		this.exp = exp;
		this.hp = hp;
		this.attack = attack;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}


}
