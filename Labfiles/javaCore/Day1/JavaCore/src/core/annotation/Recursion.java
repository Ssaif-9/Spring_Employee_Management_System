package core.annotation;
import java.lang.*;

//A Java program to demonstrate
//working of recursion
@MyAnnotation(str = "Annotation Example", val = 100)

public class Recursion {

	static void printFun(int test) {
		if (test < 1)
			return;

		else {
			System.out.printf("%d ", test );
			System.out.println("==");

			// Statement 2
			printFun(test - 1);

			System.out.printf("%d ", test);
			System.out.println("----");
			return;
		}
	}

	public static void main(String[] args) {
		int test = 3;
		printFun(test);
	}

}