package core;
import java.util.Date;


public class JavaString {
	public static void main(String[] args) {
		// System.out.println("String === Lab" + txt2);
		String txt = "Please locate where 'locate' occurs!";
		System.out.println(txt.indexOf("Please")); // Outputs 7
		String txt2 = "We are the so-called \"Vikings\" \b from the north.";
		int randomNum = (int) (Math.random() * 101); // 0 to 100
		System.out.println("String === Lab \n ..." + txt2 + "\n" + randomNum + true);
		
		
		System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
		System.out.println(txt.toLowerCase());   // Outputs "hello world"
		System.out.println(txt2.compareTo(txt));
		
		String s1 = "welcome";
		String s2 = "welcome";
		
	}

}