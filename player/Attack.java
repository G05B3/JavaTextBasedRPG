package player;

public abstract class Attack implements Comparable<Attack> {
	private String name, type;
	private int levelUnlock, cost;
	
	Attack(String s, String t, int l, int c) {
		name = s;
		type = t;
		levelUnlock = l;
		cost = c;
	}
	
	
	@Override
	public boolean equals(Object o) {
		Attack a = (Attack)o;
		return name.equals(a.getName());
	}
	
	public int getLevelUnlock() {
		return levelUnlock;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int compareTo(Attack a) {
		return this.levelUnlock - a.getLevelUnlock();
	}
	
	public abstract double[] stats();
}
