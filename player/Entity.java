package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Entity {
	
	//SP = Special Points and can be MP in case of classes like Wizard and other "special" bars for other classes
	protected int MaxHP, HP, MaxSP,SP, atk, mat, def, mdf;
	protected ArrayList<Attack> atklist;
	protected int exp, gold;
	
	//Level 1: HP/100, atk/100, mat/100, def/100, mdf/100, total must be 200
	protected Entity(int hp, int sp, int a, int ma, int d, int md) {
		MaxHP = hp;
		HP = hp;
		MaxSP = sp;
		SP = sp;
		atk = a;
		mat = ma;
		def = d;
		mdf = md;
		atklist = new ArrayList<>();
	}
	
	public int getMaxHP() {
		return MaxHP;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getMaxSP() {
		return MaxSP;
	}
	
	public int getSP() {
		return SP;
	}
	
	public String SP() {
		return "SP";
	}
	
	public int getatk() {
		return atk;
	}
	
	public int getmat() {
		return mat;
	}
	
	public int getdef() {
		return def;
	}
	
	public int getmdf() {
		return mdf;
	}
	
	public void updateHP(int dmg) {
		if (dmg > 0) {
			this.HP -= dmg;
		}
		if (this.HP < 0) {
			this.HP = 0;
		}
	}
	
	public void heal(int val) {
		this.HP+=val;
		if (this.HP > this.MaxHP) {
			this.HP = this.MaxHP;
		}
	}
	
	public void recoverSP(int val) {
		this.SP+=val;
		if (this.SP > this.MaxSP) {
			this.SP = this.MaxSP;
		}
	}
	
	public void updateSP(int cost) {
		if (cost > 0) {
			this.SP -= cost;
		}
		if (this.SP < 0) {
			this.SP = 0;
		}
	}
	
	public boolean pay(int price) {
		
		if (this.gold >= price) {
			this.gold-=price;
			return true;
		}
		
		return false;
	}
	
	protected void sortAtklist() {
		Collections.sort(atklist);
	}
	
	void setAttacks(List<Attack> list) {
		atklist.addAll(list);
		this.sortAtklist();
	}
	
	public ArrayList<Attack> getAttacks(){
		return atklist;
	}
	
}
