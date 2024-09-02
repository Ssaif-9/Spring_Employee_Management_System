package unit20;

public class Tester2 extends Thread {
    AccountSynchronized theAccount = null;
    double depositAmount = 0.0;

    public Tester2(AccountSynchronized acc, double amt) {
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
        AccountSynchronized account = new AccountSynchronized(0.0);
        Tester2 tester1 = new Tester2(account, 2);
        Tester2 tester2 = new Tester2(account, 3);

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