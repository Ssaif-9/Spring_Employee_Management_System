package unit14;

// Anonymous Inner Class with instance initializer
public class Outer4 {
    private int outerField;

    public void aMethod() {
        final int localVar = 0;

        Object in = new Object() {
            private int innerField;

            // instance initializer
            {
                innerField = 12;
            }

            public String toString() {
                return "o: " + outerField + " i: " + innerField
                        + " l: " + localVar;
            }
        };

        System.out.println(in);
    }

    public static void main(String[] args) {
        Outer4 out = new Outer4();
        out.aMethod();
    }
}