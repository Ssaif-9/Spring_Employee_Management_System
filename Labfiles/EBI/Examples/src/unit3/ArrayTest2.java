package unit3;

public class ArrayTest2 {
    public static void main(String args[]) {

        String bookInfo[][] = { 
                { "Java In a Nutshell", "Flanagan" },
                { "Core Java", "Horstmann" },
                { "Thinking in Java", "Eckel" } };

        for (int i = 0; i < bookInfo.length; i++) {
            for (int j = 0; j < bookInfo[i].length; j++) {
                System.out.print(bookInfo[i][j] + " ");
            }
            System.out.println();
        }

        for (String[] book : bookInfo) {
            for (String s : book) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
