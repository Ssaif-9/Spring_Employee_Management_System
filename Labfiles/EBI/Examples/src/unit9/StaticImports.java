package unit9;

import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImports {
    public static void main(String[] args) {
        int radius = 5;
        double area = PI * pow(radius, 2);

        out.printf(
                "The area of a circle with radius %1$d is %2$.2f %n",
                radius, area);
    }
}
