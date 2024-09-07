import java.sql.*;
import java.util.function.Function;

public class DatabaseConnection {

    private final String url = "jdbc:mysql://Localhost:3306/emp";
    private final String userName = "root";
    private final String password = "root";

    private Connection jdbcConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return connection;
    }

    public void jdbcListAllBooks()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection=this.jdbcConnection();
            statement=connection.createStatement();

            resultSet=statement.executeQuery("select * from book");
            while(resultSet.next())
            {
                System.out.printf("Book ID : %d \t Book Title : %s \t Book Author : %s \t Book Publish Year : %s .\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));

            }
            statement.close();
            connection.close();

        }catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
    }


    public void jdbcGetBook(String bookTitle) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                connection = this.jdbcConnection();
                String SQL ="select * from book  Where title = ? ";
                statement = connection.prepareStatement(SQL);

                statement.setString(1, bookTitle);

                resultSet = statement.executeQuery();
                if(resultSet==null)
                    System.out.println("Dont Find Book");
                else
                {
                    while (resultSet.next()) {
                        System.out.printf("Book ID : %d \t Book Title : %s \t Book Author : %s \t Book Publish Year : %s. \n",resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                    }
                }
                statement.close();
                connection.close();

            } catch (SQLException sqlEx) {
                System.out.println(sqlEx);
            }
    }


    public void jdbcAddRow(Book book) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet =0;
        try {
            connection = this.jdbcConnection();
            String SQL ="INSERT INTO book (id, title, auther,year) VALUES (?,?,?,?)";

            statement = connection.prepareStatement(SQL);

            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getYear());

            resultSet= statement.executeUpdate();

            if(resultSet==1)
                System.out.printf("Add %s book  done!\n",book.getTitle());
            else
                System.out.printf("can not Add %s book!\n",book.getTitle());

            statement.close();
            connection.close();

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx);
        }
    }

    public void jdbcDeleteRow(String bookTitle) {
        Connection connection =null;
        PreparedStatement statement = null;
        int resultSet = 0;

        try {
            connection=this.jdbcConnection();
            String Sql ="DELETE FROM book WHERE title = ?";
            statement = connection.prepareStatement(Sql);
            statement.setString(1, bookTitle);
            resultSet= statement.executeUpdate();

            statement.close();
            connection.close();
        }catch(SQLException sqlEx)
        {
            System.out.println(sqlEx);
        }
    }
}
