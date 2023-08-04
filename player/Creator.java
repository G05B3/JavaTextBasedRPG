package player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Creator {

	private static HashMap<String, List<Attack>> classAttacks = new HashMap<String, List<Attack>>();
	private static HashMap<String, Attack> atkList = new HashMap<String, Attack>();
	
	protected void createAttackLibrary() {
		
		atkList.put("NS", new PhysAttack("Normal Strike", 1, 0, 0.5, 0.5));
		atkList.put("PS", new PhysAttack("Power Slash", 1, 4, 1, 1));
		atkList.put("ID", new PhysAttack("Iron Dash", 3, 8, 1.5, 0.9));
		atkList.put("WC", new PhysAttack("Wind Cutter", 5, 12, 1.5, 0.6));
		atkList.put("SS", new PhysAttack("Small Stab", 1, 5, 1.4, 1));
		atkList.put("B", new PhysAttack("Bite", 1, 6, 1.7, 1.1));
	}
	
	protected void addAttacksToClasses() {
		
		classAttacks.put("Warrior", (List<Attack>) Arrays.asList(atkList.get("NS"),
				atkList.get("PS"), atkList.get("ID"), atkList.get("WC")));
		
		classAttacks.put("Goblin", (List<Attack>) Arrays.asList(atkList.get("NS"),
				atkList.get("SS")));
		
		classAttacks.put("DireWolf", (List<Attack>) Arrays.asList(atkList.get("NS"),
				atkList.get("B")));
	}
	
	public Creator() {
		createAttackLibrary();
		addAttacksToClasses();
	}
	
	public Entity create(String className) {
		return this.create("player", className);
	}
	
	//Creates a generic entity according to the input class' name, and also sets the respective attacks correclty;
	public Entity create(String packageExtension, String className) {
		 try {
	            // Get the Class object using the provided class name
	            Class<?> clazz = Class.forName(packageExtension + "." + className);

	            // Get the default constructor of the class
	            Constructor<?> constructor = clazz.getDeclaredConstructor();

	            // Create a new instance of the class
	            Object object = constructor.newInstance();	            
	            
			        
		        Entity e = (Entity) object;
		        e.setAttacks(classAttacks.get(className));
		        
		        return e;
	        
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class not found: " + className);
	        } catch (NoSuchMethodException e) {
	            System.out.println("Default constructor not found for class: " + className);
	        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
	            System.out.println("Error creating object: " + e.getMessage());
	     } 
	
		 return null;
	}
		
	
	public static void main(String[] args) {
	
		Storyteller st = new TestStory();

		st.tell();
		
	}
	
	
}
	
