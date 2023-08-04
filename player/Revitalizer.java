package player;

//Regenerates any type of "SP" by a fixed value
public class Revitalizer extends Item {

	public Revitalizer() {
		super();
	}
	
	public Revitalizer(int p) {
		super(p);
	}
	
	@Override
	//Revitalizer recovers 20SP
	public void use(Player p) {
		System.out.println("You drank the Revitalizer.");
		p.recoverSP(20);
		System.out.println("You were re-energized! You are now at " + p.getSP() + "SP!!");
	}
	
	public String toString() {
		return "Revitalizer";
	}

}
