package core.lambda;

public class LambdaDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// This lambda expression determines if one number is
		// factor of another.
		NumericTest isFactor = (n, d) -> (n % d) == 0;
		if (isFactor.test(10, 2))
			System.out.println("2 is a factor of 10");
		if (!isFactor.test(10, 3))
			System.out.println("3 is NOT a factor of 10");

		NumericTest lessThan = (n, m) -> (n < m);
		if (lessThan.test(2, 10))
			System.out.println("2 is less than 10");

		if (!lessThan.test(10, 2))
			System.out.println("10 is not less than 2");
		System.out.println();
		// This lambda expression returns true if the absolute
		// values of the arguments are equal.
		NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
		if (absEqual.test(4, -4))
			System.out.println("Absolute equal.");
		if (absEqual.test(4, -5))
			System.out.println("Absolute are not equal.");
		

	}

}
