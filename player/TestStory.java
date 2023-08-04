package player;

import java.util.Scanner;

public class TestStory implements Storyteller {
	
	public void tell() {
		
		String name, className;
		int chi;
		Creator c = new Creator();
		BattleSystem bs = new DefaultBattleSystem();
		Scanner s = new Scanner(System.in);
		System.out.println("Tell me your name: ");
		name = s.nextLine();
		
		System.out.println("Alright, so your name is " + name + ". Please tell me your role:\n* Warrior\n* Wizard ");
		className = s.nextLine();
		
			 
        Player player = (Player)c.create(className);
        player.setName(name);
        
        // Use the player object
        System.out.println("So you are " + player.getName() + ", the " + className + ". You are starting at level " + player.getLevel() + " with " + player.getHP() + " Hit Points and " + player.getSP() + " Special Points.");
        
        System.out.println("In your travels you encounter a Goblin!!");
        bs.battle(player, (Goblin)c.create("Goblin"));
	    System.out.println("You continue your travels, only to encounter another Goblin!!");
	    bs.battle(player, (Goblin)c.create("Goblin"));
	    System.out.println("Suddenly, a DireWolf approaches you, angrily!!");
	    bs.battle(player, (DireWolf)c.create("DireWolf"));
	    
	    System.out.println("After all these battles you have collected " + player.getGold() + " gold!");
	    
	    System.out.println("During your travels you find yourself unable to pass because a Goblin blocks youpr path.");
	    System.out.println("What do you do?\n1: Ask politely to pass\n2: Fight the Goblin\n3: Turn back");
	    chi = s.nextInt();
	    if (chi == 1) {
	    	System.out.println("You politely ask the Goblin to pass. It, however, isn't keen on that idea and draws his knife!");
	    	bs.battle(player, (Goblin)c.create("Goblin"));
	    	System.out.println("Having defeated the Goblin, you now proceed onwards, but you apologise to the Goblin on your way through.");
	    }
	    else if (chi == 2) {
	    	bs.battle(player, (Goblin)c.create("Goblin"));
	    	System.out.println("Having defeated the Goblin you now proceed onwards, even stepping on top of the Goblin.");
	    }
	    else if (chi == 3) {
	    	System.out.println("You turn away, saddened by this wrench thrown in your plans.");
	    }
	    
	    player.addToInventory(new HealthPotion());
	    player.printInventory();
	    player.addToInventory(new Revitalizer());
	    player.addToInventory(new HealthPotion());
	    player.printInventory();
	    System.out.println("Player Health is " + player.getHP());
	    player.useItem("HealthPotion");
	    System.out.println("Player Health is now " + player.getHP());
	    player.printInventory();
	    player.useItem("Revitalizer");
	    player.printInventory();
	    System.out.println("\n\n\n");
	    
	    Merchant m = new Merchant("Dubin");
	    m.addToSale(new HealthPotion(2));
	    m.addToSale(new Revitalizer(100));
	    
	    //Shop
	    m.interact(player);
	    
	    
	    player.printInventory();
	    player.useItem("HealthPotion");
	    player.useItem("HealthPotion");
	    player.useItem("HealthPotion");
	    player.printInventory();
	    
	    System.out.println("You reach the entrance of a cave. Do you enter it? (1: Yes, 2: No)");
	    chi = s.nextInt();
	    if (chi == 1) {
	    	
	    } else {
	    	System.out.println("You turn west, avoiding the cave entirely.");
	    }
	    //End of Story
		s.close();
	}

}