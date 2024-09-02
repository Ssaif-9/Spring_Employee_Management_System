package core;

public class InstanceOf {

	public static void main(String[] args) {
		Shape a = new Shape();
		Circle b = new Circle();
		Square c = new Square();
		Cat d = new Cat();

		if (a instanceof Shape)
			System.out.println("a is instance of Shape");
		if (b instanceof Circle)
			System.out.println("b is instance of Circle");
		if (c instanceof Square)
			System.out.println("c is instance of Square");
		if (c instanceof Shape)
			System.out.println("c can be cast to Shape");
		if (a instanceof Square)
			System.out.println("a can be cast to Square");
		System.out.println();
		// compare types of derived types
		Shape ob;
	}
}
