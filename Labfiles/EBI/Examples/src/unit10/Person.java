package unit10;

public class Person {
    private String name;

    public Person(String n) throws InvalidDataException {
        if (n == null || n.equals("")) {
            throw new InvalidDataException();
        }
        name = n;
    }

    public String toString() {
        return "Person [name=" + name + "]";
    }
}
