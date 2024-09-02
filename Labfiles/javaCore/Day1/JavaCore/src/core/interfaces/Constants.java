package core.interfaces;

public interface Constants {
	String sat = "SATURDAY";
	String sun = "SUNDAY";
	String mon = "MONDAY";
	String tue = "TUESDAY";
	String wen = "WENSDAY";
	String thu = "THURSDAY";
	String fri = "FRIDAY";

	default public void sayHi() {
		System.out.println("Hi");
	}
	private int getNext() {
		return 0;
		
	}

}