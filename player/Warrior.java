package player;

public class Warrior extends Player {
	
	
	Warrior(){
		super(100, 30, 60, 10, 20, 10);
	}
	
	public String SP() {
		return "SP";
	}
	
	public void updatelevel(int xp){
		int threshold = 50 * (1 + level * level);
		exp+=xp;
		
		System.out.println("You have gained " + xp + " exp!");
		while (exp > threshold) {
			levelUp();
			threshold = 50 * (1 + level * level);
		}
		System.out.println("You need " + (threshold - exp) + " more to level up!");
		
	}
	
	public void levelUp() {
		System.out.println("You leveled up!! Your stats have increased!");
		level++;
		statIncrease(15, 8, 15, 10, 5, 5);
		
		for (Attack a: atklist) {
			if (a.getLevelUnlock() == level) {
				System.out.println("You have learned " + a.getName() + "!!");
			}
		}
	}
	
}
