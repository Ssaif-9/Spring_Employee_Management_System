package unit12;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest2 {
    public static void main(String args[]) {
        Queue<String> myQueue = new PriorityQueue<String>();

        myQueue.offer("C");
        myQueue.offer("D");
        myQueue.offer("B");
        myQueue.offer("A");

        // must retrieve the size before the loop, because
        // poll() removes elements, reducing the size
        int size = myQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(myQueue.poll());
        }
    }
}