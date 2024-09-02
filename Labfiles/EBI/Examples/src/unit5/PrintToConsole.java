package unit5;

public class PrintToConsole {

    public static void main(String[] args) {
        System.out
                .printf("PI to 10 decimal places: %1$.10f%n", Math.PI);

        int a = 17;
        int b = -445;

        System.out.printf("Width flag set to 15: %1$15d%n", a);
        System.out.printf("Decimal value: %1$d, hex value: %1$x%n", a);
        System.out.printf("Negative in parens: %1$(d%n", b);

        String fs = "The average of %1$d, %2$d, and %3$d is %4$.2f%n";
        System.out.printf(fs, 12, 4, 6, ((12 + 4 + 6) / 3.0));

    }
}