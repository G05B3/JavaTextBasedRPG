package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Merchant implements NPC {

	protected String name;
	protected List<Item> inventory = new ArrayList<Item>();

	public Merchant(String n) {
		name = n;
	}
	
	public void addToSale(Item i) {
		inventory.add(i);
	}
	
	@Override
	public String toString() {
		String s = "";
		int idx = 1;
		
		for (Item i: inventory) {
			s += "[" + idx + "]: " + i.toString() + " for " + i.getPrice() + "G\n";
			idx++;
		}
		s += "[" + idx + "]: exit\n";
		
		return s;
	}
	
	@Override
	public void interact(Player p) {
		Scanner sc = new Scanner(System.in);
		int idx = -1;
		Item i;
		System.out.println("You approach the Merchant.");
		
		System.out.println(name + ": Howdy! I'm " + name + ", a humble Merchant!");
		System.out.println(name + ": Here's what I'm selling: ");
		System.out.println(this.toString());
		System.out.println("Anything that interests ya? (Your gold: " + p.getGold() + ")");
		do {
			try {
				//Select Item to buy
				idx = sc.nextInt();
				if (idx <= inventory.size()) {
					i = inventory.get(idx - 1);
				} else { //player wishes to stop the interaction
					System.out.println("Pleasure doin' business with ya!");
					break;
				}
				
				//If the player has enough Gold to buy the selected Item
				if (p.pay(i.getPrice()) == true) {
					System.out.println("Alrighty! One " + i.toString() + " for you then! (Your gold: " + p.getGold() + ")");
					p.addToInventory(i);
				} else {
					System.out.println("Sorry! Ya ain't got enough money to buy this " + i.toString() + "!");
				}
				
			} catch(InputMismatchException ime) {
				 sc.nextLine();
				 continue;
			}
		}while(idx != 0);
		
		sc.close();
	}

}
