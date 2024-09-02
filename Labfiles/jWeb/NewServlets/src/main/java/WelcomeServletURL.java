

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServletURL
 */
public class WelcomeServletURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig myConfig;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServletURL() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) 
    {
    	myConfig = config;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String str = myConfig.getInitParameter("AdminEmail");
		PrintWriter out = response.getWriter();
		out.println ("The administrator email is: " + str);
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<FORM method= POST>");
		out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR> Password: <INPUT TYPE=PASSWORDNAME=password>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");


		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.equals("userName"))
		// check against Data Base
		{
			response.sendRedirect("WelcomeServletURL");
		} else {
			out.println("Login Failed, please try again.");
			// Draw the form again
		}

	}

}