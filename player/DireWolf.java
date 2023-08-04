package player;

public class DireWolf extends Enemy {

	DireWolf() {
		super(80, 24, 44, 10, 15, 16);
	}

	@Override
	Attack algorithm(Player p) {
		
		Attack a = atklist.get(1);
		
		if (p.getHP() > p.getMaxHP() * 0.5 && SP >= a.getCost()) {
			return a;
		}
		
		return atklist.get(0);
	}

	@Override
	int getEXP() {
		return getEG(73,11);
	}

	@Override
	int getGold() {
		return getEG(32,8);
	}

}
