package unit20;

public class Tester3 extends Thread {
    AccountSynchronized2 theAccount = null;
    double depositAmount = 0.0;

    public Tester3(AccountSynchronized2 acc, double amt) {
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
        AccountSynchronized2 account = new AccountSynchronized2(0.0);
        Tester3 tester1 = new Tester3(account, 2);
        Tester3 tester2 = new Tester3(account, 3);

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