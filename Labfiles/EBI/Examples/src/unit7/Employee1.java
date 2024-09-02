package unit7;

public class Employee1 extends Person {
    private String title;
    private float salary;

    public Employee1() {
        this("", "", 0, "Clerk", 20000);
    }

    public Employee1(String l, String f, int a, String t, float s) {
        lastName = l;
        firstName = f;
        age = a;
        title = t;
        salary = s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        if (title.equals("Doctor"))
            return "Dr. " + firstName + " " + lastName;
        return firstName + " " + lastName;
    }
}
