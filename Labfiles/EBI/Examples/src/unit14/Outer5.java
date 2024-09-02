package unit14;

// Static Nested Class
public class Outer5 {
    private static int outerStaticField;

    public void aMethod() {
        Inner in = new Inner();
        System.out.println(in);
    }

    static class Inner {
        private int innerField;
        public String toString() {
            return "o: " + outerStaticField + " i: " + innerField;
        }
    }
}
