
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewServlet
 */
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig sConfig;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewServlet() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Hello I Am in : init");
		sConfig = config;
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Hello I Am in : destroy");
		// config = null;
		// System.out.println("Hello"+ config.toString());

	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "info";
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello I Am in : service");
		PrintWriter out = response.getWriter();
		out.append("in service");
		doPost(request, response);
		/////////////////////////////////////// Excel //////////
		/*
		 * response.setContentType("application/vnd.ms-excel");
		 * out.println("\t jan \t feb \t march \t total");
		 * out.println("salary \t100 \t200 \t300 \t=sum(B2:D2)");
		 */
		//////////////////////////// Config
		
		  ServletContext servletContext = sConfig.getServletContext();
		  servletContext.setAttribute("MyPassword", "EBI "); 
		  String str = (String)servletContext.getAttribute("MyPassword"); 
		  out.println("MyPassword is: " + str);
		 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = request.getRequestDispatcher("WelcomeServletURL");
		rd.forward(request, response);
		doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<FORM method= POST>");
		out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR> Password: <INPUT TYPE=PASSWORDNAME=password>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");

		// add cookies
		Cookie c1 = new Cookie("UserName", "userName");
		response.addCookie(c1);

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				out.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>");
				out.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>");
			}

		}
	}
}