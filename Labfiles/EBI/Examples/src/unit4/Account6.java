package unit4;

public class Account6 {
    private double balance;
    private String accountId;
    private static int nextId = 0;
    public static final int ROUTING_NUMBER = 123456789;

    public Account6() {
        this(0.0);
    }

    public Account6(double initialBalance) {
        balance = initialBalance;
        this.setAccountId(Account6.getNextId());
    }

    public String getAccountId() {
        return accountId;
    }

    private void setAccountId(String id) {
        accountId = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void display() {
        System.out.println("**Account Information**");
        System.out.println("  ID: " + accountId);
        System.out.println("  Balance: " + balance);
    }

    private static String getNextId() {
        return "ACCT-" + Account6.nextId++;
    }
}
