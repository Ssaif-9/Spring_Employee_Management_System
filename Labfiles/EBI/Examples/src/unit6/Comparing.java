package unit6;

public class Comparing {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(10, 10);

        if (r1 == r2)
            System.out.println("Rectangle are ==");

        if (r1.equals(r2))
            System.out.println("Rectangle are 'equal'");
    }
}