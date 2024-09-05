class MyTask1 implements Runnable{
    @Override
    public void run(){
        for (int i = 0 ; i < 5 ; i++ )
        {
            System.out.println("Welcome !");
        }
    }
}

class MyTask2 implements Runnable{
    @Override
    public void run(){
        for (int i = 0 ; i < 5 ; i++ )
        {
            System.out.println("Hello !");
        }
    }
}


public class Main {

    public static void main(String[] args) {

        MyTask1 task1 = new MyTask1();
        Thread thread1 = new Thread(task1);


        MyTask2 task2 = new MyTask2();
        Thread thread2 = new Thread(task2);

        thread2.start();
        thread1.start();


        thread2.run();
        thread1.run();


    }
}
