package unit5;

public class EmpTest5 {
    public static void main(String[] args) {
        Employee5 e = new Employee5("Bob", "Dobbs");
        e.setSalary(59900.00F);
        e.setId(42);
        e.showEmp();

        // Test the no-arg constructor
        Employee5 e2 = new Employee5();
        e2.showEmp();
    }
}
