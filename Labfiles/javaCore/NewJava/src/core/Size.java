package core;

enum Size {
	SMALL(1), MEDIUM(2), LARGE(3), EXTRALARGE(4);

	Size(int i) {
		// TODO Auto-generated constructor stub
	}

	public String getSize() {

		// this will refer to the object SMALL
		switch (this) {
		case SMALL:
			return "small";

		case MEDIUM:
			return "medium";

		case LARGE:
			return "large";

		case EXTRALARGE:
			return "extra large";

		default:
			return null;
		}
	}

	public static void main(String[] args) {

		// call getSize()
		// using the object SMALL
		System.out.println("The size of the pizza is " + Size.SMALL.getSize());

	}
}