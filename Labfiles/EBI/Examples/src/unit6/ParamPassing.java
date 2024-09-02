package unit6;

public class ParamPassing {
    public static void main(String[] args) {
        Clock clock = new Clock(10, 18, 0);
        int theHour = 19;
        StringBuilder theManufacturer = new StringBuilder("Timex");
        clock.setHour(theHour);
        clock.setManufacturer(theManufacturer);

        System.out.println(clock);
        System.out.println(theHour);
        System.out.println(theManufacturer);
    }
}