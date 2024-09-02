package unit4;

public class Customer5 {
    String firstName;
    String lastName;
    Account5 acc;

    Customer5(String fName, String lName) {
        this(fName, lName, 0.0);
    }

    Customer5(String fName, String lName, double initialBalance) {
        firstName = fName;
        lastName = lName;
        acc = new Account5(initialBalance);
        acc.display();
    }
}
