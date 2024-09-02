import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnect {
    private static final DBConnect dbConnect = new DBConnect();
    private DataSource dataSource;

    private DBConnect() {
        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:/comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/myschema");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static DBConnect gDbConnect() {
        return dbConnect;
    }

    public Connection getConnectio() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
