package unit14;

// Anonymous Inner Class
public class Outer3 {
    private int outerField;

    public void aMethod() {
        final int localVar = 0;

        Object in = new Object() {
            private int innerField;
            public String toString() {
                return "o: " + outerField + " i: " + innerField
                        + " l: " + localVar;
            }
        };

        System.out.println(in);
    }

    public static void main(String[] args) {
        Outer3 out = new Outer3();
        out.aMethod();
    }
}