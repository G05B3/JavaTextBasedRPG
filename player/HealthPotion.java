package player;

public class HealthPotion extends Item {

	
	public HealthPotion() {
		super();
	}
	
	public HealthPotion(int p) {
		super(p);
	}
	
	//Health Potion heals 50HP
	public void use(Player p) {
		System.out.println("You drank the Health Potion.");
		p.heal(50);
		System.out.println("You were healed! You are now at " + p.getHP() + "HP!!");
	}
	
	public String toString() {
		return "HealthPotion";
	}
}
