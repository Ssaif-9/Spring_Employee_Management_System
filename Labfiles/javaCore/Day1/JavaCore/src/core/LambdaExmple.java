package core;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaExmple {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		// use lambda expression
		numbers.forEach((n) -> {
			System.out.println(n);
		});

		// use lambda in functional interface
		Consumer<Integer> method = (n) -> {System.out.println(n);};
		numbers.forEach(method);
		
		// use lambda in a method
		StringFunction exclaim = (s) -> s + "!";
	    StringFunction ask = (s) -> s + "?";
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);

	}
	public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);
	    System.out.println(result);
	  }

}
