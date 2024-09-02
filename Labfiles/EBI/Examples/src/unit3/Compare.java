package unit3;

public class Compare {

    public static void main(String[] args) {
        if (args.length == 2) {
            // check ==
            if (args[0] == args[1])
                System.out.println("Both Strings are ==");
            else
                System.out.println("Both Strings are NOT ==");

            // check equals()
            if (args[0].equals(args[1]))
                System.out.println("Both Strings are 'equal'");
            else
                System.out.println("Both Strings are NOT 'equal'");
        }
        else {
            System.out.println("Usage: java Compare arg1 arg2");
        }
    }
}
