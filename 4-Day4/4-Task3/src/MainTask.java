public class MainTask {
    private static boolean isAllLetter(String string)
    {
        boolean allLetters = true;
        for(char c : string.toCharArray())
        {
            if(!Character.isLetter(c))
                allLetters = false;
        }
        return allLetters;
    }
    public static void main(String[] args) {

        if(isAllLetter("dfgsdf999gd"))
            System.out.println("ALL LETTERS");
        else
            System.out.println("NOT ALL LETTERS");
    }
}