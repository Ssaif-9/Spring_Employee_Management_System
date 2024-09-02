@Author(name = "Seif Eldin",salary = 159753)
public  class Employee {
    @Author(name = "sultan",salary = 74563)
    private String employeeName;
    private int employeeSalary;

    public Employee() {}

    @Author(name = "OTHMAN",salary = 159753)
    public Employee(String name,int salary) {
        this.employeeName = name;
        this.employeeSalary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Author(name = "Mohammed",salary = 159753)
    public void sayHay()
    {
        System.out.println("Welcome " + getEmployeeName());
        System.out.println("Your Salary is " + getEmployeeSalary());
    }
}
