package core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstDatabaseApp {

	public FirstDatabaseApp() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//DriverManager dm = Class.forName("com.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:xe",
			"scott","tigger"); Statement stmt = con.createStatement() ;
			String queryString = new String("select * from tab");
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
