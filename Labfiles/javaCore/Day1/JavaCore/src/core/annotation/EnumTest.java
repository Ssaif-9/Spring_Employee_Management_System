package core.annotation;

public class EnumTest {
	Week week;

	public EnumTest(Week week) {
		this.week = week;
	}

	public void tellItLikeItIs() {
		switch (week) {
		case MONDAY:
			System.out.println("Mondays are starting work.");
			break;

		case FRIDAY:
			System.out.println("Fridays are better for work.");
			break;

		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;

		default:
			System.out.println("Midweek days are 50/50.");
			break;
		}
	}

	public static void main(String[] args) {
		EnumTest firstDay = new EnumTest(Week.MONDAY);
		firstDay.tellItLikeItIs();
		EnumTest thirdDay = new EnumTest(Week.WEDNESDAY);
		thirdDay.tellItLikeItIs();
		EnumTest fifthDay = new EnumTest(Week.FRIDAY);
		fifthDay.tellItLikeItIs();
		EnumTest sixthDay = new EnumTest(Week.SATURDAY);
		sixthDay.tellItLikeItIs();
		EnumTest seventhDay = new EnumTest(Week.SUNDAY);
		seventhDay.tellItLikeItIs();
	}
}