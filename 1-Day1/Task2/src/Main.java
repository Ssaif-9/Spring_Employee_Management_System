import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public int countOccurrencesUsingNormalString(String inputString, String inputWord) {
        int count=0;
        String [] Words = inputString.split(" ");
        for(String word : Words) {
            if(word.equals(inputWord)) {
                count++;
            }
        }
        return count;
    }
    public int countOccurrencesUsingRegex(String inputString, String inputWord) {
        int count=0;
        String regexPattern = "\\b" + inputWord + "\\b";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(inputString);
        while(matcher.find()) {
            count++;
        }
        return count;
    }
    public int countOccurrencesUsingStringTokenizer(String inputString, String inputWord) {
        int tokenCounter=0;
        StringTokenizer inString =new StringTokenizer(inputString," ");
        while (inString.hasMoreTokens())
        {
            if (inString.nextToken().equals(inputWord))
                tokenCounter++;
        }
        return tokenCounter;
    }

    public int countOfWordInString (String inputString) {
        String [] words = inputString.split(" ");
        int count=0;
        for(String word : words) {
            count++;
        }
        return count;
    }

    public int countOfWordInStringUsingRegex (String inputString) {
        int count=0;
        String regexPattern="\\w+";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(inputString);

        while(matcher.find()) {
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        String inputString =args[0];
        String inputWord = args[1];
        Main module = new Main();

        System.out.println("Using Normal String Class : ");
        System.out.println("inputString --> " + inputString);
        System.out.println("inputWord   --> " + inputWord);
        System.out.printf("Count of Word in String is %d.\n\n",module.countOccurrencesUsingNormalString(inputString, inputWord));

        System.out.println("Using Regex String Class : ");
        System.out.println("inputString --> " + inputString);
        System.out.println("inputWord   --> " + inputWord);
        System.out.printf("Count of Word in String is %d.\n\n",module.countOccurrencesUsingRegex(inputString, inputWord));

        System.out.println("Using Tokenizer String Class : ");
        System.out.println("inputString --> " + inputString);
        System.out.println("inputWord   --> " + inputWord);
        System.out.printf("Count of Word in String is %d.\n\n",module.countOccurrencesUsingStringTokenizer(inputString, inputWord));


        System.out.printf("Count of Words in String is %d.\n",module.countOfWordInString(inputString));
        System.out.printf("Count of Words in String Using REGEX is %d.\n",module.countOfWordInStringUsingRegex(inputString));


    }
}