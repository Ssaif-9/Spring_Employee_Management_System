import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection url = DriverManager.getConnection("jdbc:mysql://Localhost:3306/emp");
            Statement stmt = url.createStatement();
            String sql =new String( "select * from emp");
            ResultSet rs = stmt.executeQuery("select * from emp");
            {
                while(rs.next()){
                    System.out.println("ID : "+rs.getInt(1)+"First Name : "+rs.getString(2)+"Last Name : "+rs.getString(3)+"Salary : "+rs.getInt(4));
                }
            }
            stmt.close();
            url.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}