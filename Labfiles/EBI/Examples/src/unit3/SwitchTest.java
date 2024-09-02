package unit3;

public class SwitchTest {
    static char grade = 'A';

    public static void main(String[] args) {
        switch (args[0]) {
        case "A":
            System.out.println("Great Job");
            break;
        case "B":
            System.out.println("Good Job");
            break;
        case "C":
            System.out.println("Average Job");
            break;
        case "D":
            System.out.println("Poor Job");
            break;
        case "F":
            System.out.println("Bad Job");
            break;
        default:
            System.out.println("Illegal grade");
            break;
        }
    }
}
