package unit3;

public class IfTest {
    static double totalSales = 33000.0;

    public static void main(String[] args) {
        double bonus = 0.0;

        if (totalSales < 30000)
            bonus = totalSales * 0.050;

        // when will the following line print?
        System.out.println("Small bonus awarded: " + bonus);

        if (totalSales >= 30000) {
            bonus = totalSales * 0.075;
            // when will the following line print?
            System.out.println("Large bonus awarded: " + bonus);
        }
    }
}
