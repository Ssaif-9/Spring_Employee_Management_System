import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.resource.cci.ResultSet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class regist extends HttpServlet {

    DBConnect dbConnect = DBConnect.gDbConnect();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        if (request.getParameter("registered") != null) {
            printWriter.println("Registered");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/regist.html");
        requestDispatcher.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = dbConnect.getConnectio();
        PrintWriter printWriter = response.getWriter();

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into myschema.users values(?,?,?,?)");
            preparedStatement.setString(1, request.getParameter("userName"));
            preparedStatement.setString(2, request.getParameter("first"));
            preparedStatement.setString(3, request.getParameter("last"));
            preparedStatement.setString(4, request.getParameter("password"));
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("re?registered=true");
    }
}
