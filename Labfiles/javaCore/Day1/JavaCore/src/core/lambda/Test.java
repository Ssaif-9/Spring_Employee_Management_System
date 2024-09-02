package core.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Using an anonymous class
		Supplier<List<String>> s = new Supplier<List<String>>() {
			public List<String> get() {
				return new ArrayList<String>();
			}
		};
		List<String> l = s.get();
		// Using a lambda expression
		Supplier<List<String>> s1 = () -> new ArrayList<String>();
		List<String> l1 = s1.get();
		// Using a method reference
		Supplier<List<String>> s2 = ArrayList<String>::new;
		List<String> l2 = s2.get();
		System.out.println(l + "----" + l1 + " ----- " + l2);

	}

}
