package unit4;

public class Account5 {
    double balance;
    String accountId;
    static int nextId = 0;
    static final int ROUTING_NUMBER = 123456789;

    Account5() {
        this(0.0);
    }

    Account5(double initialBalance) {
        balance = initialBalance;
        accountId = Account5.getNextId();
    }

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount) {
        balance = balance - amount;
    }

    void display() {
        System.out.println("**Account Information**");
        System.out.println("  ID: " + accountId);
        System.out.println("  Balance: " + balance);
    }

    static String getNextId() {
        return "ACCT-" + Account5.nextId++;
    }
}
