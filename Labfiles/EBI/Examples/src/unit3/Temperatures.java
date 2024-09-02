package unit3;

public class Temperatures {

    public static void main(String[] args) {

        for (int c = 0; c <= 100; c++) {
            float f = c * (9F/5F) + 32;
            System.out.println(c + " Celsius is " + f + " Fahrenheit");
        }
    }
}
