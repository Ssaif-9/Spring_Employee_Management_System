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

public class Serv extends HttpServlet {

    DBConnect dbConnect = DBConnect.gDbConnect();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        // printWriter.write("kdjlf");

        if (request.getParameter("loginBoolean") != null) {
            printWriter.println("Login Failed , Please Try Again");
        }

        // printWriter.println("<html>");
        // printWriter.println("<FORM method=post>");
        // printWriter.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
        // printWriter.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
        // printWriter.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
        // printWriter.println("</FORM>");
        // printWriter.println("</html>");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
        requestDispatcher.include(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = dbConnect.getConnectio();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM myschema.users where userName=? and password=? ");
            preparedStatement.setString(1, request.getParameter("userName"));
            preparedStatement.setString(2, request.getParameter("password"));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("wel");
                requestDispatcher.forward(request, response);
                // response.sendsRedirect("wel");
            } else {
                response.sendRedirect("login?loginBoolean=false");
                // RequestDispatcher requestDispatcher = request.getRequestDispatcher("login");
                // requestDispatcher.include(request, response);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // String name = request.getParameter("userName");
        // String pass = request.getParameter("password");

        // if (pass.equals("1234") && name.equals("zizo")) {
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher("wel");
        // requestDispatcher.forward(request, response);
        // // response.sendRedirect("wel");
        // } else {
        // response.sendRedirect("login?loginBoolean=false");
        // // RequestDispatcher requestDispatcher =
        // request.getRequestDispatcher("login");
        // // requestDispatcher.include(request, response);
        // }
    }
}
