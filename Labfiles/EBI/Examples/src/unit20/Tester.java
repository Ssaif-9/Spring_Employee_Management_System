package unit20;

public class Tester extends Thread {
    Account theAccount = null;
    double depositAmount = 0.0;

    public Tester(Account acc, double amt) {
        theAccount = acc;
        depositAmount = amt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            theAccount.deposit(depositAmount);
        }
    }

    public static void main(String[] args) {
        Account account = new Account(0.0);
        Tester tester1 = new Tester(account, 2);
        Tester tester2 = new Tester(account, 3);

        tester1.start();
        tester2.start();

        try {
            tester1.join();
            tester2.join();
        }
        catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("End balance is: " + account.getBalance());
    }
}