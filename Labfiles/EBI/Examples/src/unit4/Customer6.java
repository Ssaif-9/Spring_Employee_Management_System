package unit4;

public class Customer6 {
    private String firstName;
    private String lastName;
    private Account6 acc;

    public Customer6(String fName, String lName) {
        this(fName, lName, 0.0);
    }

    public Customer6(String fName, String lName, double initialBalance) {
        firstName = fName;
        lastName = lName;
        acc = new Account6(initialBalance);
        acc.display();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public Account6 getAccount() {
        return acc;
    }
}
