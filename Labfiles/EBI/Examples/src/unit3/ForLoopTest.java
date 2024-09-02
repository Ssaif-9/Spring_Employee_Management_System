package unit3;

public class ForLoopTest {

    public static void main(String[] args) {

        for (int i = 0, j = 10; i < 10; i++, j--) {
            if (i <= j) {
                continue;
            }
            System.out.println("i is : " + i + ", j is : " + j);
        }
    }
}
