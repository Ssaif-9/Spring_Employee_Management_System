package unit20;

public class Account {
    double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        // balance += amount;
        double tempBalance = balance;
        Thread.yield(); // try to force race condition
        tempBalance = tempBalance + amount;
        balance = tempBalance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
