import java.lang.reflect.Method;

public class Main {
    @Author(name = "Seif Sultan", salary = 25000)
    public static void myMethod() {
        Main ob = new Main();
        // Obtain the annotation for this method and display the
        // values of the members.
        try {
            // First, get a Class object that represents this class.
            Class<?> c = ob.getClass();
            // Now, get a Method object that represents this method.
            Method m = c.getMethod("myMethod");              // Another class ??
            // Next, get the annotation for this class.
            Author an =
                    m.getAnnotation(Author.class);
            // Finally, display the values.
            System.out.println("Name is [" +an.name() + "] AND " +"Salary [" + an.salary() + "].\n");
        } catch (Exception e) {
            System.out.println("Method	Not	Found.");
        }
    }
    public static void main(String[] args) {
        myMethod();
        }
    }