import java.sql.*;

public class DatabsaseConnection {

    private Connection jdbcConnection() {
        Connection url = null;
        try {
            url = DriverManager.getConnection("jdbc:mysql://Localhost:3306/emp", "root", "root");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return url;
    }

    public void jdbcListAllBooks()
    {
        Connection url = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            url=this.jdbcConnection();
            statement=url.createStatement();
            resultSet=statement.executeQuery("select * from book");
            while(resultSet.next())
            {
                System.out.printf("Book ID : %d \t Book Title : %s \t Book Author : %s \t Book Publish Year : %s .\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));

            }

         statement.close();
         url.close();
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void jdbcGetRow(String book) {
        Connection url = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            url = this.jdbcConnection();
            String SQL ="select * from book  Where title = ? ";
            stmt = url.prepareStatement(SQL);

            stmt.setString(1, book);

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Book ID : %d \t Book Title : %s \t Book Author : %s \t Book Publish Year : %s .",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }

            stmt.close();
            url.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    public void jdbcAddRow(Book book) {
        Connection url = null;
        PreparedStatement stmt = null;
        int rs = 0;
        try {
            url = this.jdbcConnection();
            String SQL ="INSERT INTO book (id, title, auther,year) VALUES (?,?,?,?)";

            stmt = url.prepareStatement(SQL);

            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getYear());

            stmt.executeUpdate();

            stmt.close();
            url.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
