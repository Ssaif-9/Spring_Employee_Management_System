package unit20;

public class DeadLockExample {
    public PrintValues pv;
    public ValueGenerator vg;

    public DeadLockExample() {
        pv = new PrintValues();
        vg = new ValueGenerator();
        pv.start();
        vg.start();
    }

    class PrintValues extends Thread {
        public PrintValues() {
            this.setName("Print Values Thread");
        }

        public synchronized void print() {
            logLockAcquire(getClass().getSimpleName());
            logMethodCall("ng.getNextNumber()");
            int number = vg.getNextValue();
            System.out.println("Retrieved number is: " + number + "\n");
        }

        public synchronized void print(int num) {
            logLockAcquire(getClass().getSimpleName());
            System.out.println("Passed in number is: " + num + "\n");
        }

        public void run() {
            for (int i = 0; i < 100; i++) {
                this.print();
            }
        }
    }

    class ValueGenerator extends Thread {
        private int value;

        public ValueGenerator() {
            this.setName("Value Generator Thread");
        }

        public synchronized void displayCurrentValue() {
            logLockAcquire(getClass().getSimpleName());
            logMethodCall("pn.print(value)");
            pv.print(value);
        }

        public synchronized int getNextValue() {
            logLockAcquire(getClass().getSimpleName());
            return ++value;
        }

        public void run() {
            int currentNumber = value;
            while (true) {
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentNumber != value) {
                    displayCurrentValue(); // 3
                    currentNumber = value;
                }
            }
        }
    }

    private void logLockAcquire(String className) {
        System.out.println(Thread.currentThread().getName()
                + " is holding the lock for " + className);
    }

    private void logMethodCall(String method) {
        System.out.println(Thread.currentThread().getName()
                + " is calling " + method);
    }

    public static void main(String[] args) {
        new DeadLockExample();
    }

}
