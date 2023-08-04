package player;

public class PhysAttack extends Attack {
	
	//if (k = c1 * p_atk - c2 * e_def > 0) => HP-=k;
	private double c1, c2;
	public double[] stats() {
		double[] c = {c1, c2};
		return c;
	}
	
	PhysAttack(String s, int l, int c, double d, double e){
		super(s, "Phys", l, c);
		this.c1 = d;
		this.c2 = e;
	}
}
