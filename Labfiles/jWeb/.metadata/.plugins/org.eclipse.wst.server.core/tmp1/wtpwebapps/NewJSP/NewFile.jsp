<%@page import="java.util.TimeZone"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page session="false"%>
<%@ page autoFlush="false"%>
<%@ page errorPage="ErrorPage.jsp"%>
<%@ include file="/ErrorPage.jsp"%>


<%@ include file="header.html"%>


<HTML>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Enumeration parameters = request.getParameterNames();
	String param = null;
	while (parameters.hasMoreElements()) {
		param = (String) parameters.nextElement();
		out.println(param + ":" + request.getParameter(param) + "<BR>");
	}
	//out.close();

	out.println("Hello JSP");
	Date date = new Date();
	out.print("<h2 align = \"center\">" + date.toString() + "</h2>");
	%>

	<%!String getSystemTime() {
		return Calendar.getInstance().getTime().toString();
	}%>


	<%!int x;%>
	<%
	out.println(" <BR> <BR> The New System Time : " + Calendar.getInstance().getTime().toString() + "<BR><BR>");
	%>

	<%=java.util.Calendar.getInstance().getTime()%>
	<jsp:scriptlet>out.println("new JSP scriptlet");</jsp:scriptlet>

	<%-- Use Beans --%>
	<jsp:useBean id="myBean" class="com.mybeans.MyFirstBean" />

	<jsp:setProperty name="myBean" property="firstName" value="Ali" />

	<jsp:getProperty name="myBean" property="firstName" />

	<%
	int isbn = 1;
	try {
		isbn = Integer.parseInt(request.getParameter("isbNum"));
	} catch (NumberFormatException nfe) {
		out.println("Error Catched");
	}
	%>
	<jsp:setProperty name="bookBean" property="isbn" value="<%=isbn%>" />


	<%@ include file="Footer.html"%>
</body>
</html>