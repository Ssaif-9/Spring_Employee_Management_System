package core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main implements Numbers{
	
	public void PrintWithEllipsis(String...setOfStrings) {
	    for (String s : setOfStrings)
	        System.out.println(s);
	}
	public static void main(String[] args) {
		int x = ~6;

		System.out.println("Hello World" + true + x );
		Main m = new Main();
		m.PrintWithEllipsis(); // prints nothing
		m.PrintWithEllipsis("first"); // prints "first"
		m.PrintWithEllipsis("first", "second"); // prints "first\nsecond"
		
		// Using lambda expression
		Comparator<String> c = (s1, s2) -> s1.length() - s2.length();

		// Using :: operator
		Comparator<String> c2 = Comparator.comparing(String::length);
		
		// Using lambda expression
		List<String> list = Arrays.asList("a", "b", "c");
		list.forEach(s -> System.out.println(s));

		// Using :: operator
		List<String> list2 = Arrays.asList("a1", "b1", "c1");
		list2.forEach(System.out::println);
	}
	@Override
	public int getNext() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setStart(int x) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saySomething() {
		// TODO Auto-generated method stub
		
	}
}