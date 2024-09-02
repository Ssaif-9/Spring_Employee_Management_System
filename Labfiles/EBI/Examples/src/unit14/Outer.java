package unit14;

// Member Inner Class
public class Outer {
    private int outerField;

    public void aMethod() {
        Inner in = new Inner();
        System.out.println(in);
    }

    class Inner {
        private int innerField;
        public String toString() {
            // explicit access to outerField
            // return "o: " + Outer.this.outerField + " i: " + innerField;

            // implicit access to outerField
            return "o: " + outerField + " i: " + innerField;
        }
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        out.aMethod();
    }
}
