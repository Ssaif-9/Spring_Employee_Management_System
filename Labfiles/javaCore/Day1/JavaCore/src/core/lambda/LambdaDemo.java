package core.lambda;

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyValue myVal;
		/*
		 * declare an interface reference Here, the lambda expression is simply a
		 * constant expression. When it is assigned to myVal, a class instance is
		 * constructed in which the lambda expression implements the getValue() method
		 * in MyValue.
		 */
		myVal = () -> 98.6;
		/*
		 * Call getValue(), which is provided by the previously assigned lambda
		 * expression.
		 */
		System.out.println("A constant value: " + myVal.getValue());
		MyParamValue myPval = (n) -> 1.0 / n;
		// Call getValue(v) through the myPval reference.
		System.out.println("Reciprocal of 4 is " + myPval.getValue(4.0));
		System.out.println("Reciprocal of 8 is " + myPval.getValue(8.0));
	}
}
