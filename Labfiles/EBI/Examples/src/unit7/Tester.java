package unit7;

public class Tester {
    public static void main(String args[]) {
        Person mom = new Person("Doe", "Jane", 71);
        Employee1 doc = new Employee1("Smith", "John", 45, "Doctor",
                275000);
        Person p;

        p = mom;
        System.out.println(p.getName()); // which method?

        p = doc;
        System.out.println(p.getName()); // which method?
    }
}
