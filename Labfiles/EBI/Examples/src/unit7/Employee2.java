package unit7;

public class Employee2 extends Person2 {
    private String title;
    private float salary;

    public Employee2() {
        this("", "", 0, "Clerk", 20000);
    }

    public Employee2(String l, String f, int a, String t, float s) {
        super(l, f, a);
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

    public String getName() {
        if (title.equals("Doctor"))
            return "Dr. " + super.getName();
        return super.getName();
    }
}
