package unit3;

public class ArrayTest {
    public static void main(String args[]) {

        int odds[] = { 1, 3, 5, 7, 9 };

        for (int i = 0; i < odds.length; i++) {
            System.out.println(odds[i]);
        }

        for (int num : odds) {
            System.out.println(num);
        }
    }
}
