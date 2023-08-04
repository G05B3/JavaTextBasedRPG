package player;

import java.util.Random;

public abstract class Enemy extends Entity{

	protected Enemy(int hp, int sp, int a, int ma, int d, int md) {
		super(hp, sp, a, ma, d, md);
		// TODO Auto-generated constructor stub
	}

	protected int getEG(int a, int b) {
		Random r = new Random();
		return a + r.nextInt(b);
	}
	
	abstract Attack algorithm(Player p);
	
	abstract int getEXP();
	abstract int getGold();
}
