package player;

public abstract class Item {
	
	protected int price = 0;
	
	public Item() {
		
	}
	
	public Item(int p) {
		price = p;
	}
	
	public int getPrice() {
		return price;
	}
	public abstract void use(Player p);
}
