package player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class DefaultBattleSystem implements BattleSystem{
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public boolean battle(Player p, Enemy e) {
		Scanner s = new Scanner(System.in);
		int atk = 0, sz;
		Attack a = null;
		while(e.getHP() > 0 && p.getHP() > 0) {
			sz = battle_HUD(p, e);
			do {
				System.out.print("> ");
				try {
				atk = s.nextInt();
				s.nextLine();
				a = p.getAttacks().get(atk - 1);
				} catch(InputMismatchException ime) {
					 System.out.println("Invalid Input.");
					 s.nextLine();
					 continue;
				}
			}while(atk < 1 || atk > sz || p.getSP() < a.getCost());
			System.out.println("You chose " + a.getName());
			performAttack(p, e, a);
			
			try {
				TimeUnit.MILLISECONDS.sleep(500); //sleep for 0.5 seconds
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (e.getHP() <= 0) { //In case your attack beat the enemy
				break;
			}
			
			receiveAttack(p, e); //Enemy's turn
		}
		if (e.getHP()<= 0) {
			System.out.println("You have defeated the " + e.getClass().getName().split("\\.")[1] + "!!");
			p.updatelevel(e.getEXP());
			p.updategold(e.getGold());
			
			return true;
		}
		else {
			System.out.println("You have been defeated!!");
			return false;
		}
	}
	
	
	private void receiveAttack(Player p, Enemy e) {
		int damage = 0;
		Random r = new Random();
		Attack a = e.algorithm(p);
		System.out.println("The " + e.getClass().getName().split("\\.")[1] + " uses " + a.getName() + "!!");
		if (a.getType().equals("Phys")) {
			damage = (int)(e.getatk() * a.stats()[0] - p.getdef() * a.stats()[1]);
		}
		p.updateHP(damage + r.nextInt((int)(1 + damage * 0.1)));
		e.updateSP(a.getCost());
	}
	
	
	private void performAttack(Player p, Enemy e, Attack a) {
		int damage = 0;
		Random r = new Random();
		if (a.getType().equals("Phys")) {
			damage = (int)(p.getatk() * a.stats()[0] - e.getdef() * a.stats()[1]);
		}
		e.updateHP(damage + r.nextInt((int)(damage * 0.1)));
		p.updateSP(a.getCost());
	}
	
	private void color_text(int s1, int s2) {
		if (s1 > (int)s2 * 0.5) {
			System.out.print(ANSI_GREEN);
		}
		else if (s1 > (int)(s2 * 0.25)) {
			System.out.print(ANSI_YELLOW);
		}
		else {
			System.out.print(ANSI_RED);
		}
		System.out.print("" + s1 + ANSI_RESET);
	}
	
	
	private int battle_HUD(Player p, Enemy e) {
		System.out.println("\nWhat do you do?");
		System.out.print(p.getName() + "(lvl " + p.getLevel() + "): [HP: ");
		color_text(p.getHP(),p.getMaxHP());
		System.out.print("; " + p.SP() + ": ");
		color_text(p.getSP(), p.getMaxSP());
		
		System.out.print("]         " + e.getClass().getName().split("\\.")[1] + ": [HP: ");
		color_text(e.getHP(), e.getMaxHP());
		System.out.println("]");
		
		int i = 0;
		for (Attack a: p.getAttacks()) {
			if (a.getLevelUnlock() > p.getLevel()) {
				break;
			}
			i++;
			System.out.println(i + ": " + a.getName() + "[cost: " + a.getCost() + "]");
		}
		
		return i;
	}

}
