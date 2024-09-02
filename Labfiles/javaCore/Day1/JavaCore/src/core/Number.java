package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Number {

	public static boolean isMoreThanFifty(int n1, int n2) {

		return (n1 + n2) > 50;
	} // end of isMoreThanFifty

	public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	} // end of findNumbers

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
		// Using an anonymous class
		findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return Number.isMoreThanFifty(i1, i2);
			}
		});
		
		// Using a lambda expression
		findNumbers(list, (i1, i2) -> Number.isMoreThanFifty(i1, i2));
		// Using a method reference
		findNumbers(list, Number::isMoreThanFifty);

	}// end of main method

	public String getNext() {
		// TODO Auto-generated method stub
		return null;
	}

} // end of class
