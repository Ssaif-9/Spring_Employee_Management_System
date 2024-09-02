public class ThreeMethods {

    public void sendMessage(String message)throws MyException{
        if(message.equals("No Message"))
            throw new MyException("Please Enter Massage. \n");
        else
            System.out.println(message);
    }

    public void sayMyName(String name)throws MyException{
        if(name.equals("No Name"))
            throw new MyException("Please Enter Name.\n");
        else
            System.out.println(name);
    }

    public void setRole (String role)throws MyException{
        if(role.equals("No Role"))
            throw new MyException("Please Enter role.\n");
        else
            System.out.println(role);
    }
}
