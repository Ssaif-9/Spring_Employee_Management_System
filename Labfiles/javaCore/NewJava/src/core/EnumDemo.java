package core;

class EnumDemo {
	public static void main(String args[]) {
		Week ap;
		ap = Week.Sunday;
		// Output an enum value. System.out.println("Value of ap: " + ap);
		// System.out.println();
		ap = Week.Wednesday;
		// Compare two enum values.
		if (ap == Week.Wednesday)
			System.out.println("Current	week	day	is	Wednesday.\n");
		// Use an enum to control a switch statement.
		switch (ap) {
		case Saturday:
			System.out.println("Today	is	Saturday.");
			break;
		case Sunday:
			System.out.println("Today	is	Sunday.");
			break;
		case Monday:
			System.out.println("Today	is	Monday.");
			break;
		case Tuesday:
			System.out.println("Today	is	Tuesday.");
			break;
		case Friday:
			System.out.println("Today	is	Friday.");
			break;
		}
	}
}
