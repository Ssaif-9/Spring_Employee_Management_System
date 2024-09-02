package unit18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepParamExample {
    public PrepParamExample() {
        String url = "jdbc:derby://localhost:1527/java";
        String sql = "SELECT department_name FROM department "
                + "WHERE department_code = ?";

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pst = conn.prepareStatement(sql);) {

            System.out.println(getDeptName(pst, "RD"));
            System.out.println(getDeptName(pst, "HR"));
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }

    private String getDeptName(PreparedStatement pst, String deptid)
            throws SQLException {
        pst.setString(1, deptid);
        ResultSet rs = pst.executeQuery();
        String dept = "";
        while (rs.next()) {
            dept += rs.getString(1) + "\n";
        }
        return dept;
    }

    public static void main(String args[]) {
        new PrepParamExample();
    }
}
