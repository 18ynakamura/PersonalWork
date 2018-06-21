package entity;

public class CharLvJoin {
private int c_hp;
private int attack;

public CharLvJoin(int c_hp, int attack){
	this.c_hp = c_hp;
	this.attack = attack;
}
public int getC_hp() {
	return c_hp;
}
public void setC_hp(int c_hp) {
	this.c_hp = c_hp;
}
public int getAttack() {
	return attack;
}
public void setAttack(int attack) {
	this.attack = attack;
}
}
