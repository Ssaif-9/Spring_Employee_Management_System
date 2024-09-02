package unit7;

public class Employee extends Person {
    private String title;
    private float salary;

    public Employee() {
        this("", "", 0, "Clerk", 20000);
    }

    public Employee(String l, String f, int a, String t, float s) {
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
}
