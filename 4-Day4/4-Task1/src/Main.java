import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    private static void printArea ( List<? extends Shape> list )
    {
        for(Shape ob : list)
             System.out.println(ob);
    }

    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(10,20);
        Rectangle R2 = new Rectangle(5,10);
        Rectangle R3 = new Rectangle(15,30);

        Circle C1 = new Circle(10);
        Circle C2 = new Circle(5);
        Circle C3 = new Circle(15);

        List<Shape> list = new ArrayList<>();

        list.add(R1);           list.add(R2);
        list.add(R3);           list.add(C1);
        list.add(C2);           list.add(C3);

        for(Shape ob : list)
            ob.drow();
    }
}