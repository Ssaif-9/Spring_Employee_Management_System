import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Book book = new Book(4,"C++","SASA","2026");
        DatabaseConnection connection = new DatabaseConnection();
        connection.jdbcAddRow(book);
        //connection.jdbcDeleteRow("Rust");
        //connection.jdbcGetBook("java");
        //connection.jdbcListAllBooks();

    }
}