package unit3;

public class InitTest {
    int count;           // Automatically initialized to 0
    double budget;       // Automatically initialized to +0.0D
    String name;         // Automatically initialized to null
    final int max = 100; // Initialize final before use

    void firstMethod() {
        int k = 42;
        System.out.println("The value of k is: " + k);
        // int j;           // not initialized, so...
        // System.out.println("Testing: " + j); // Compiler Error!
    }

    void secondMethod() {
        count = count + 1; // We can use the count field here.
        // k = 17;         // Compiler Error!
        // max = 50;       // Compiler Error!
    }
}
