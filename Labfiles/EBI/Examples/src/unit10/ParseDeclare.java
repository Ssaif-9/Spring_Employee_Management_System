package unit10;

import java.text.NumberFormat;
import java.text.ParseException;

public class ParseDeclare {

    public float parseIt(String s) throws ParseException {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number num = format.parse(s); // may generate exception

        return num.floatValue();
    }

    public static void main(String[] args) {
        ParseDeclare parser = new ParseDeclare();
        String s;
        s = "$45.67";
        // s = "hi mom";

        try {
            System.out.println("Float value = " + parser.parseIt(s));
        }
        catch (ParseException e) {
            System.err.println("Invalid string \"" + s + "\"");
        }
        finally {
            System.out.println("Original string was \"" + s + "\"");
        }
    }
}
