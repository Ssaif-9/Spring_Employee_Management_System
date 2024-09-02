package unit17;

import java.sql.*;

public class EmployeeQuery {
    public static void main(String args[]) {
        String URL = "jdbc:derby://localhost:1527/java";
        String sqltxt = "SELECT ID, FIRSTNAME, LASTNAME FROM EMPLOYEE";

        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqltxt);) {

            while (rs.next()) {
                System.out.println(rs.getString(1) + " "
                        + rs.getString(2) + " " + rs.getString(3));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }
}