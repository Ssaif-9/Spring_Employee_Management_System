import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

    DBConnect dbConnect = DBConnect.gDbConnect();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.html");
        requestDispatcher.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // String search= response.sendRedirect("search");
        Connection connection = dbConnect.getConnectio();
        PrintWriter printWriter = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search.html");
        requestDispatcher.include(request, response);

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from myschema.users where firstName like ? ");

            preparedStatement.setString(1, "%" + request.getParameter("search") + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            printWriter.print("<center>");
            printWriter.print("<table>");
            printWriter.print("<tr>");
            printWriter.print("<th> " + " First Name  " + "</th> ");
            printWriter.print("<th> " + "Last Name" + "</th> ");
            printWriter.print("<th> " + "User Name" + "</th> ");
            printWriter.print("<th> " + "Password" + "</th> ");
            printWriter.print("</tr>");

            while (resultSet.next()) {
                printWriter.print("<tr>");
                printWriter.print("<td>" + resultSet.getString(2) + "</td>");
                printWriter.print("<td>" + resultSet.getString(3) + "</td>");
                printWriter.print("<td>" + resultSet.getString(1) + "</td>");
                printWriter.print("<td>" + resultSet.getString(4) + "</td>");
                printWriter.print("</tr>");
            }
            printWriter.print("</table>");
            printWriter.print("</center>");
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // printWriter.println("<html>");

        // printWriter.println("<body style='text-align: center;'>");

        // printWriter.println("</body>");

        // printWriter.println("</html>");
    }

}
