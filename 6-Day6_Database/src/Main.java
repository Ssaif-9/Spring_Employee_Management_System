import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection url = DriverManager.getConnection("jdbc:mysql://Localhost:3306/emp","root","root");
            //Statement stmt = url.createStatement();
            String sql = "select * from employee where id = ? or first_name = ? ";
            PreparedStatement pstmt = url.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.setString(2,"ahmed");
            ResultSet rs = pstmt.executeQuery(); //if stmt must send sql to executeQuery
            {
                while(rs.next()){
                    System.out.println("ID : "+rs.getInt(1)+" "
                                      +"First Name : " +rs.getString(2)+" "
                                      +"Last Name : "+rs.getString(3)+" "
                                      +"Salary : "+rs.getInt(4));
                }
            }
            pstmt.close();
            url.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}