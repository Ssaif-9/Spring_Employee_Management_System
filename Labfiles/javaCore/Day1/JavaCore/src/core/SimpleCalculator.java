package core;

public class SimpleCalculator implements Numbers{

	int op1,op2;
	String operation;
	
	public int add(int x, int y) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome: " + args[0] + "\t" + args[1]);
		int op1 = Integer.parseInt(args[0]);
		int op2 = Integer.parseInt(args[2]);
		String operation = args[1];
		switch (operation) 
		
		{
		case "+":
			System.out.println("the sum is: " + (op1 + op2));
			break;
		case "-":
			System.out.println("the Sub is: " + (op1 - op2));
			break;
		case "x":
			System.out.println("the Multiply is: " + (op1 * op2));
			break;
		case "/":
			System.out.println("the Div is: " + (op1 / op2));
			break;
		case "%":
			System.out.println("the Reminder is: " + (op1 % op2));
			break;
		default:
			System.out.println("Invalid operation, please choose valid operation");
			

			// calling methods
			SimpleCalculator sc = new SimpleCalculator();
			int result = sc.add(op1, op2);
			
		}

	}

	@Override
	public int getNext() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStart(int x) {
		// TODO Auto-generated method stub
		
	}

}
