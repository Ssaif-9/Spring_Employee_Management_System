package unit7;

public class HumanResources {

    public HumanResources() {
        Employee boss = new Employee("Lee", "Jan", 71, "Manager",
                900000);
        Employee lead = new Employee("Dobbs", "Bob", 54, "Lead", 75000);

        if (isPastRetirement(boss)) {
            System.out.println(boss.getName() + " can retire.");
        }

        if (isPastRetirement(lead)) {
            System.out.println(lead.getName() + " can retire.");
        }
    }

    public boolean isPastRetirement(Person p) {
        // will the following line compile?
        // float salary = p.getSalary();

        if (p.getAge() > 65) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        new HumanResources();
    }
}
