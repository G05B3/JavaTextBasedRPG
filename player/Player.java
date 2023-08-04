package player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Entity{

	protected int level;
	protected String name;
	protected List<Item> inventory = new ArrayList<Item>();
	
	protected Player(int hp, int sp, int a, int ma, int d, int md) {
		super(hp, sp, a, ma, d, md);
		level = 1;
		gold = 0;
	}
	
	public int getLevel() {
		return level;
	}

	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void printInventory() {
		for (Item i: inventory) {
			System.out.println(i.toString());
		}
	}
	
	
	//Uses a Consumable Item
	public void useItem(String ItemName) {
		int idx = 0;
		for (Item i: inventory) {
			if (i.toString().equals(ItemName)) {
				i.use(this);
				inventory.remove(idx);
				return;
			}
			idx++;
		}
		System.out.println("You do not have any " + ItemName + "s!");
	}
	
	public void addToInventory(Item i) {
		inventory.add(i);
	}
	
	
	public void statIncrease(int h, int s, int a, int d, int ma, int md) {
		MaxHP+=h;
		HP+=h;
		MaxSP+=s;
		SP+=s;
		atk+=a;
		def+=d;
		mat+=ma;
		mdf+=md;
	}
	
	public void updategold(int g) {
		gold+=g;
		System.out.println("You gained " + g + " gold!");
	};
	
	public abstract void updatelevel(int xp);
	
	public abstract void levelUp();
}
