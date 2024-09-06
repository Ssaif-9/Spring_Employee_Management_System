import java.sql.*;

public class Main {

    public static void main(String[] args) {

        //Book book = new Book(4,"Rust","mohsen","2021");
        DatabsaseConnection connection = new DatabsaseConnection();
        //connection.jdbcAddRow(book);
        connection.jdbcListAllBooks();
    }
}