package com.ebi.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the login form
        response.setContentType("text/html");
        response.getWriter().append(
            "<html>" +
            "<head><title>Registration Page</title></head>" +
            "<body>" +
            "<h2>Register</h2>" +
            "<form method='POST' >" +
            "ID: <input type='text' name='id'><br>" +
            "First Name: <input type='text' name='first_name'><br>" +
            "Second Name: <input type='text' name='second_name'><br>" +
            "Salary: <input type='text' name='salary'><br>" +
            "<input type='submit' value='Profile'>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle login logic
        String stringId = request.getParameter("id");
        String stringFirstName = request.getParameter("first_name");
        String stringSecondName = request.getParameter("second_name");
        String stringSalary = request.getParameter("salary");
        
        int intId = Integer.parseInt(stringId);
        
        
        Employee emp = new Employee();
        ConnectionDB conn = new ConnectionDB();

        emp.setId(intId);
        emp.setFirst_name(stringFirstName);
        emp.setSecond_name(stringSecondName);
        emp.setSalary(stringSalary);
        
        conn.addEmployee(emp);
       
        
        
        
    }

}
