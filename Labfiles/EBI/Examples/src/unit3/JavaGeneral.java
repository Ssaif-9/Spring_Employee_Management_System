package unit3;

import java.time.Instant;
import java.util.Date;
import java.util.Iterator;

public class JavaGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String txt = "asassABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//System.out.println("The length of the txt string is: " + txt.length());
		String txt = "Please locate where 123 + 'locate' occurs!";
		System.out.println(txt.lastIndexOf("locate")); // Outputs 7
		
		String firstName = "John ";
		String lastName = "Doe";
		String x = "10";
		String y = "20";
		String z = x + y;  // z will be 1020 (a String)
		String txts = "We are the so-called \"Vikings\" from the north.";
		
		System.out.println(firstName.concat(lastName) + "\n" + z + txts );
		System.out.println("Hi" + Math.log(1.2) );
		
		int time = 20;
		String result = (time < 18) ? "Good day." : "Good evening.";
		System.out.println(result + Instant.now().toString() );
		
	//	int day = Instant.now();
		Date d = new Date();
		int day = d.getDay();
		switch (day) {
		  case 1:
		    System.out.println("Monday");
		    break;
		  case 2:
		    System.out.println("Tuesday");
		    break;
		  case 3:
		    System.out.println("Wednesday");
		    break;
		  case 4:
		    System.out.println("Thursday");
		    break;
		  case 5:
		    System.out.println("Friday");
		    break;
		  case 6:
		    System.out.println("Saturday");
		    break;
		  case 7:
		    System.out.println("Sunday");
		    break;
		    
		  default:
			    System.out.println("Not Defined");
			    break;
		}
	
		// Outputs "Thursday" (day 4)
		
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		cars[0] = "Opel";
		for (String i : cars) {
		  System.out.println(i + cars.length);
		  continue;
		}
		
		
		//int[] numbers = {10, 20, 30, 40};
		/*
		 * int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
		 * System.out.println(myNumbers[0][2]); // Outputs 7
		 * 
		 * int[][] myNumberss = { {1, 2, 3, 4}, {5, 6, 7} }; myNumberss[1][2] = 9;
		 * System.out.println(myNumberss[1][2]); // Outputs 9 instead of 7
		 */
		int[][] myNumbersss = { {1, 2, 3, 4}, {5, 6, 7} };
	    for (int[] row:myNumbersss) {
	      for(int col:row) {
	        System.out.print(col + " ");
	        
	      }
	     
	      System.out.println();
	      
	      }
	    
	}
}
