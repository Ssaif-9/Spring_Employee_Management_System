package unit12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// import java.util.LinkedList;

public class ListTest {
    public static void main(String args[]) {
        CD cd1 = new CD(1, "The Beatles", "The Beatles 1");
        CD cd2 = new CD(2, "Prince", "The Very Best of Prince");
        CD cd3 = new CD(3, "Garth Brooks", "The Ultimate Hits");

        List<CD> cdCollection = new ArrayList<>();
        // List<CD> cdCollection = new LinkedList<CD>();

        cdCollection.add(cd1);
        cdCollection.add(cd2);
        cdCollection.add(0, cd3);

        for (int i = 0; i < cdCollection.size(); i++) {
            System.out.println(cdCollection.get(i));
        }
        
        // another way to loop through the list
        for (CD cd : cdCollection) {
            System.out.println(cd);
        }
        
        // yet another way to loop through the list
        Iterator<CD> it = cdCollection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}