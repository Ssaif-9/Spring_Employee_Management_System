public class Main {
    public static void main(String[] args) throws MyException {
        ThreeMethods TH = new ThreeMethods();
        try{
            TH.sendMessage(args[0]);
            TH.sayMyName(args[1]);
            TH.setRole(args[2]);
        } catch (MyException my) {
            System.out.println(my.getMessage());
        }
    }
}