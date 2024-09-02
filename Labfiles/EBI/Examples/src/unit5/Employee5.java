package unit5;

public class Employee5 {
    public static int retirementAge = 72;
    public static float minimumWage = 6.75F;

    private String firstName;
    private String lastName;
    private float salary;
    private int id;

    // constructors
    public Employee5(String fname, String lname) {
        firstName = fname;
        lastName = lname;
    }

    public Employee5() {
        this("J.", "Doe");
    }

    public void showEmp() {
        System.out.println("Employee " + "(Min Wage: " + minimumWage
                + ", Ret Age: " + retirementAge + "):");

        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Salary: " + salary);
    }

    // gets and sets
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float s) {
        salary = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }
}
