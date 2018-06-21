package entity;

public class Monster {
	private int monster_id;
	private String monster_name;
	private int monster_level;
	private int monster_hp;
	private int monster_attack;
	public int getMonster_id() {
		return monster_id;
	}
	public Monster(int monster_id, String monster_name, int monster_level, int monster_hp, int monster_attack) {
		this.monster_id = monster_id;
		this.monster_name = monster_name;
		this.monster_level = monster_level;
		this.monster_hp = monster_hp;
		this.monster_attack = monster_attack;
	}
	public Monster() {
	}
	public void setMonster_id(int monster_id) {
		this.monster_id = monster_id;
	}
	public String getMonster_name() {
		return monster_name;
	}
	public void setMonster_name(String monster_name) {
		this.monster_name = monster_name;
	}
	public int getMonster_level() {
		return monster_level;
	}
	public void setMonster_level(int monster_level) {
		this.monster_level = monster_level;
	}
	public int getMonster_hp() {
		return monster_hp;
	}
	public void setMonster_hp(int monster_hp) {
		this.monster_hp = monster_hp;
	}
	public int getMonster_attack() {
		return monster_attack;
	}
	public void setMonster_attack(int monster_attack) {
		this.monster_attack = monster_attack;
	}
}
