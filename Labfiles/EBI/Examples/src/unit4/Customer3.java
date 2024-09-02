package unit4;

public class Customer3 {
    String firstName;
    String lastName;
    Account3 acc;

    void addAccount(double initialBalance) {
        acc = new Account3();
        acc.accountId = "ACCT-" + Account3.nextId++;
        acc.balance = initialBalance;
        System.out.println(acc.accountId + " added");
    }
}
