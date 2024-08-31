public class Main {
    public int countOccurrences(String inputString, String inputWord) {
        int count=0;
        String [] Words = inputString.split(" ");
        for(String word : Words) {
            if(word.equals(inputWord)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String inputString =args[0];
        String inputWord = args[1];
        Main module = new Main();
        System.out.println("inputString --> " + inputString);
        System.out.println("inputWord   --> " + inputWord);
        System.out.printf("Count of Word in String is %d.\n",module.countOccurrences(inputString, inputWord));
    }
}