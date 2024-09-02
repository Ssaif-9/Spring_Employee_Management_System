package core;

public class ControStatement {

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]); // April
		String season;

		if (month == 12 || month == 1 || month == 2)
			season = "Winter";
		else if (month == 3 || month == 4 || month == 5)
			season = "Spring";
		else if (month == 6 || month == 7 || month == 8)
			season = "Summer";
		else if (month == 9 || month == 10 || month == 11)
			season = "Autumn";
		else
			season = "Unknown Month";
		System.out.println("This Month is in " + season + ".");
		
		// just if-else sample
		/*
		 * int x, y; if (x < y) { System.out.println("x i s less than y"); } else {
		 * System.out.println("x i s either equals y or greater than y"); }
		 */
	}

}
