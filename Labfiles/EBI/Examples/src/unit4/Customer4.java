package unit4;

public class Customer4 {
    String firstName;
    String lastName;
    Account4 acc;

    void addAccount() {
        acc = new Account4();
        acc.accountId = Account4.getNextId();
        acc.balance = 0;
        acc.display();
    }

    void addAccount(double initialBalance) {
        acc = new Account4();
        acc.accountId = Account4.getNextId();
        acc.balance = initialBalance;
        acc.display();
    }
}
