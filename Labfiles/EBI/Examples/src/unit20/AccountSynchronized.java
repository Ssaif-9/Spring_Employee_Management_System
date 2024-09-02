package unit20;

public class AccountSynchronized {
    double balance;

    public AccountSynchronized(double initialBalance) {
        balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        // balance += amount;
        double tempBalance = balance;
        Thread.yield(); // try to force race condition
        tempBalance = tempBalance + amount;
        balance = tempBalance;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
