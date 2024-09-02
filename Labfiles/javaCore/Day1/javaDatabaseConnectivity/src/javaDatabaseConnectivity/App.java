package javaDatabaseConnectivity;

import java.sql.*;

public class App {
    public App() {
        try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
            Statement state = con.createStatement();
            String query = new String("SELECT * FROM emp.employees");
            ResultSet resultset = state.executeQuery(query);
            while (resultset.next()) {
                System.out.println(
                        ("Employee_id= " + resultset.getInt(1)) + "   " + " first_name = " + resultset.getString(2));
            }
            state.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new App();
    }
}