package unit4;

public class Account3 {
    double balance;
    String accountId;
    static int nextId = 0;
    static final int ROUTING_NUMBER = 123456789;

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount) {
        balance = balance - amount;
    }
}
