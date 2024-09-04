import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {
    private static String betterString (String first, String second , BiPredicate<String,String> compare)  {
    if(compare.test(first,second))
        return first;
    else
        return second;
    }

    public static void main(String[] args) {

       String betterBasedLength= betterString("saif","sultan",(s1,s2)-> s1.length() > s2.length() );
        System.out.println("Better String Based Length " + betterBasedLength );

        String betterBasedFirstLetter= betterString("saif","sultan",(s1,s2)-> s1.compareTo(s2)<0);
        System.out.println("Better String Based FirstLetter " + betterBasedFirstLetter );

    }
}