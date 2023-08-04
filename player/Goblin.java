package player;

public class Goblin extends Enemy {

	Goblin() {
		super(40, 15, 30, 5, 10, 10);
	}
	
	Attack algorithm(Player p) {
		
		Attack a = atklist.get(1);
		
		if (p.getHP() > p.getMaxHP() * 0.5 && SP >= a.getCost()) {
			return a;
		}
		
		return atklist.get(0);
	}
	
	int getEXP() {
		return getEG(50,10);
	}
	
	int getGold() {
		return getEG(20, 8);
	}
	
}
