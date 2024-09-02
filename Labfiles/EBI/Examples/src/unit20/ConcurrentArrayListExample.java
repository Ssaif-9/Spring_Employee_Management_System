package unit20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArrayListExample {
    static int numWrites = 100;
    List<String> list;

    public ConcurrentArrayListExample() {
        list = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            list.add("Item" + i);
        }
    }

    public void useConcurrentArrayList() {
        List<String> localList = new CopyOnWriteArrayList<>(list);

        long start = System.currentTimeMillis();
        // lots of reads
        for (int i = 0; i < localList.size(); i++) {
            localList.get(i);
        }
        // some writes
        for (int i = 0; i < numWrites; i++) {
            localList.add("New String");
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for concurrent: " + (end - start)
                + " ms.");
    }

    public void useSynchronizedArrayList() {
        List<String> localList = Collections.synchronizedList(list);

        long start = System.currentTimeMillis();
        // lots of reads
        for (int i = 0; i < localList.size(); i++) {
            localList.get(i);
        }
        // some writes
        for (int i = 0; i < numWrites; i++) {
            localList.add("New String");
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for synchronized: " + (end - start)
                + " ms.");

    }

    public static void main(String[] args) {
        ConcurrentArrayListExample ex = new ConcurrentArrayListExample();
        ex.useConcurrentArrayList();
        ex.useSynchronizedArrayList();
    }
}