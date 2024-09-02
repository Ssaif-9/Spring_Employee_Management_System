import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Employee Em = new Employee();
        try {
            Class<?> c = Em.getClass();
            Method m = c.getMethod("Mohammed");
            Author AU = m.getAnnotation(Author.class);

            System.out.println(AU.name() + " " + AU.salary());

        } catch (NoSuchMethodException E) {
            System.out.println("Method not found.");
        }
    }
}