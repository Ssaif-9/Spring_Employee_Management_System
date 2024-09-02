package unit14;

// Use a Member Inner Class
public class TestInner {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner in = out.new Inner();
        System.out.println(in);
    }
}
