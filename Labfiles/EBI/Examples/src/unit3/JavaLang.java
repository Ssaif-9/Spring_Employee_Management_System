package unit3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Level {
	LOW, MEDIUM, HIGH
}

public class JavaLang {

	public static void main(String[] args) {
		Level myVar = Level.MEDIUM;

		switch (myVar) {
		case LOW:
			System.out.println("Low level");
			break;
		case MEDIUM:
			System.out.println("Medium level");
			break;
		case HIGH:
			System.out.println("High level");
			break;
		}
		for (Level myVar2 : Level.values()) {
			System.out.println(myVar2 + "\n" );
		}
		
		 LinkedList<String> cars = new LinkedList<String>(); cars.add("Volvo");
		  cars.add("BMW"); cars.add("Ford"); cars.add("Mazda");
		 System.out.println(cars); cars.set(0, "Opel"); Collections.sort(cars); for
		 (String i : cars) { System.out.println(i); }
		 System.out.println("\n The ArrayList has " + cars.size() + " elements only");
		 
		
		 // Create a HashMap object called capitalCities
	    HashMap<String, String> capitalCities = new HashMap<String, String>();

	    // Add keys and values (Country, City)
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    //Iterator<String> it = cars.iterator();
		
		  for (Iterator iterator = cars.iterator(); iterator.hasNext();) 
		  { String
			  string = (String) iterator.next(); 
		  	   System.out.print(string + "\t");
		  
		  }  
	    
	    System.out.println("\n"+capitalCities);
	    System.out.println(capitalCities.get("England") + " Size = " +capitalCities.size());
	 // Print keys and values
	    for (String i : capitalCities.keySet()) {
	      System.out.println("key: " + i + " => "+" value: " + capitalCities.get(i));
	    }
	    
	    System.out.println("==========================================");
	    Pattern pattern = Pattern.compile("w3schools", Pattern.LITERAL);
	    Matcher matcher = pattern.matcher("Visit w3schools!");
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      System.out.println("Match found");
	    } else {
	      System.out.println("Match not found");
	    }
	}
}
