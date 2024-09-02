package unit6;

public class TestToString {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(12, 5);
        System.out.println("Object with toString defined:");
        System.out.println(r);

        Square s = new Square(5);
        System.out.println("Object without toString defined:");
        System.out.println(s);
    }
}
