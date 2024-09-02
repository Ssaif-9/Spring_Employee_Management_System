package unit14;

// Use a Static Nested Class
public class TestNested {
    public static void main(String[] args) {
        // no need to instantiate enclosing instance
        Outer5.Inner in = new Outer5.Inner();
        System.out.println(in);
    }
}
