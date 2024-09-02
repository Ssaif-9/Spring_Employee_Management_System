package unit4;

public class Customer2 {
    String firstName;
    String lastName;
    Account2 acc;

    void addAccount(double initialBalance) {
        acc = new Account2();
        acc.balance = initialBalance;
        System.out.println("Account added for " + firstName + " "
                + lastName);
    }
}
