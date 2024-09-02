package unit18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class EmpSals {

    public static void main(String args[]) {
        String url = "jdbc:derby://localhost:1527/java";
        String sqltxt;
        sqltxt = "SELECT firstname, lastname, salary, department_name"
          + " FROM employee, department " +
          " WHERE employee.department_code=department.department_code";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqltxt);) {

            String name;
            String dept;
            float salary;
            while (rs.next()) {
                name = rs.getString("firstname") + " "
                        + rs.getString("lastname");
                dept = rs.getString("department_name");
                salary = rs.getFloat("salary");
                System.out.println(name + "\t" + dept + "\t" + salary);
            }
        }
        catch (SQLException sqle) {
            System.err.println("SQL Error:");
            System.err.println("     Code: " + sqle.getErrorCode());
            System.err.println("  Message: " + sqle.getMessage());
        }
    }
}
