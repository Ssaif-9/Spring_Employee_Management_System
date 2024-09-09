package com.mypackage;

import jakarta.servlet.*;
public class MyServlet implements servlet{
    {

        public void init(ServletConfig config) throws ServletException
        {
            System.out.println("I am inside the init method");
        }

        public ServletConfig getServletConfig()
        {
            return null;
        }

        public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException
        {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Welcome to Servlets and JSP Course");
            System.out.println("I am inside the service method");
        }

        public void destroy()
        {
            System.out.println("I am inside the destroy method");
        }

        public String getServletInfo()
        {
            return null;
        }
    }
}