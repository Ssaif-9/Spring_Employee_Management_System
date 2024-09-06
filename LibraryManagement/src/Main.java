import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Book book = new Book(3,"Rust","mohsen","2021");
        DatabaseConnection connection = new DatabaseConnection();
        //connection.jdbcAddRow(book);
        //connection.jdbcDeleteRow("Rust");
        //connection.jdbcGetBook("java");
        connection.jdbcListAllBooks();

    }
}