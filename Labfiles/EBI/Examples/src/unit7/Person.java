package unit7;

public class Person {
    protected String lastName;
    protected String firstName;
    protected int age;

    public Person() {
        this("", "", 0);
    }

    public Person(String l, String f, int a) {
        lastName = l;
        firstName = f;
        age = a;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }
}
