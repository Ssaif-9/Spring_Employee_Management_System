package unit3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; // Import the Scanner class

class Main {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		System.out.println("Enter name, age and salary:");

		// String input
		String name = myObj.nextLine();

		// Numerical input
		int age = myObj.nextInt();
		double salary = myObj.nextDouble();

		// Output input by user
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Salary: " + salary);
		LocalDateTime mydate = LocalDateTime.now(); // Create a date object
	    System.out.println(mydate); // Display the current date
	    
	    LocalDateTime myDateObj = LocalDateTime.now();
	    System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);
	}
}