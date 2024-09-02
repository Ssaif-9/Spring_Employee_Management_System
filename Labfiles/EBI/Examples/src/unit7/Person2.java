package unit7;

public class Person2 {
    private String lastName;
    private String firstName;
    private int age;

    public Person2() {
        this("", "", 0);
    }

    public Person2(String l, String f, int a) {
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
