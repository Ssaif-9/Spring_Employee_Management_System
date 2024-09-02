package core.annotation;

import java.util.Calendar;

public class EnumDemo {

	public static void main(String[] args) {
		Week ap;
		ap = Week.TUESDAY;
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		// Output an enum value.
		System.out.println("Value	of	ap:	" + ap);
		System.out.println();
		ap = Week.FRIDAY;
		// Compare two enum values.
		if (ap == Week.FRIDAY)
			System.out.println("I said that Current	week	day	is	Tuesday.\n + " + dayOfWeek);
		// Use an enum to control a switch statement.
		switch (dayOfWeek) {
		case 1:
			System.out.println("But Today	is	Sunday.");
			break;
		case 2:
			System.out.println("But Today	is	Monday.");
			break;
		case 3:
			System.out.println("But Today	is	Tuesday.");
			break;
		case 4:
			System.out.println("But Today	is	Wensday.");
			break;
		case 5:
			System.out.println("But Today	is	Thursday.");
			break;
		case 6:
			System.out.println("But Today	is	Friday.");
			break;
		case 7:
			System.out.println("But Today	is	saturday.");
			break;
		default : 
			System.out.println("None.");
			break;
		}

	}

}
