package unit14;

// Local Inner Class
public class Outer2 {
    private int outerField;

    public void aMethod() {
        final int localVar = 0;

        class Inner {
            private int innerField;
            public String toString() {
                return "o: " + outerField + " i: " + innerField
                        + " l: " + localVar;
            }
        }

        Inner in = new Inner();
        System.out.println(in);
    }

    public static void main(String[] args) {
        Outer2 out = new Outer2();
        out.aMethod();
    }
}
