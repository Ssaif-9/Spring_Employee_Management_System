package unit3;

public class CountDown {

    public static void main(String[] args) {

        int counter = 10;
        while (true) {
            if (counter == 0) {
                break;
            }
            System.out.println(counter--);
        }
        System.out.println("Blast off!");
    }
}
