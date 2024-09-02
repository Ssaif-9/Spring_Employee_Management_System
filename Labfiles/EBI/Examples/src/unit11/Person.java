package unit11;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Person {
    private String name;
    private String favoriteFood;
    private int age;

    public Person(String n, String f, int a) {
        name = n;
        favoriteFood = f;
        age = a;
    }

    @Override
    public String toString() {
        return name + " is " + age + " and likes " + favoriteFood + ".";
    }

    public static void main(String[] args) {
        String firstName = null;
        String food = null;
        int age = 0;

        try {
            InputStreamReader conv = new InputStreamReader(System.in);
            BufferedReader buf = new BufferedReader(conv);

            System.out.print("What is your first name? ");
            firstName = buf.readLine();
            System.out.print("How old are you, " + firstName + "? ");
            age = Integer.parseInt(buf.readLine());
            System.out.print("And what is your favorite food? ");
            food = buf.readLine();
            buf.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Person p = new Person(firstName, food, age);
        System.out.println(p);
    }
}
